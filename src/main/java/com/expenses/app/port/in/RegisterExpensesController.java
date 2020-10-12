package com.expenses.app.port.in;

import com.expenses.app.port.domain.ExpensesCommandItem;
import com.expenses.app.useCase.RegisterExpensesUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RegisterExpensesController {

    private final RegisterExpensesUseCase useCase;

    @Autowired
    public RegisterExpensesController(final RegisterExpensesUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/expenses")
    public ResponseEntity saveExpensesRecord(@RequestBody @Validated ExpensesCommandItem expensesCommand) {

        log.info("Executing post expenses controller {}", expensesCommand);

        useCase.saveExpenses(expensesCommand);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
