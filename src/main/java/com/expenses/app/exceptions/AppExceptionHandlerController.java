package com.expenses.app.exceptions;

import com.expenses.app.exceptions.custom.RecordPresentException;
import com.expenses.app.exceptions.model.ApiError;
import com.expenses.app.exceptions.model.ExpensesError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class AppExceptionHandlerController {

    @ExceptionHandler(RecordPresentException.class)
    public final ResponseEntity<ApiError> handleDuplicateKeyException(final RecordPresentException ex) {
        log.error("Duplicate key error - Response status {}", HttpStatus.CONFLICT, ex);
        return buildBasicError(ex, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        log.error("Request error - Response status {}", HttpStatus.CONFLICT, ex);
        List<String> allErrors = ex.getBindingResult().getAllErrors()
                .stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());

        final List<ExpensesError> errors = allErrors.stream().map(ExpensesError::new)
                .collect(Collectors.toList());

        final ApiError apiError = new ApiError(HttpStatus.CONFLICT, ex);
        apiError.setDetails(errors);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
    }

    private ResponseEntity<ApiError> buildBasicError(Exception ex, HttpStatus statusCode) {
        final ApiError apiError = new ApiError(statusCode, ex);
        final List<ExpensesError> errors = Collections.singletonList(new ExpensesError(ex.getLocalizedMessage()));
        apiError.setDetails(errors);
        return ResponseEntity.status(statusCode).body(apiError);
    }
}
