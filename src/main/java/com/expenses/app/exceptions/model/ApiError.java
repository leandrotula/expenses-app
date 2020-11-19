package com.expenses.app.exceptions.model;

import com.fasterxml.jackson.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName(value = "error")
public class ApiError {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ")
    private ZonedDateTime timestamp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ExpensesError> details;

    @JsonIgnore
    private String debugMessage;

    private ApiError() {
        timestamp = ZonedDateTime.now();
    }

    public ApiError(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.debugMessage = ex.getLocalizedMessage();
    }

    public HttpStatus getStatus() {
        return status;
    }

    private void addSubError(ExpensesError error) {
        if (details == null) {
            details = new ArrayList<>();
        }
        details.add(error);
    }

    private void addValidationError(String field, Object rejectedValue, String message) {
        addSubError(new ExpensesError(field, rejectedValue, message));
    }

    private void addValidationError(String message) {
        addSubError(new ExpensesError(message));
    }

    private void addValidationError(ObjectError objectError) {
        this.addValidationError(
                objectError.getDefaultMessage());
    }

    public List<ExpensesError> getDetails() {
        return details;
    }

    public void setDetails(List<ExpensesError> details) {
        this.details = details;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

}

