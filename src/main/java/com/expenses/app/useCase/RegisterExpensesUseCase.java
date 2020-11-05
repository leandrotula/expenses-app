package com.expenses.app.useCase;

import com.expenses.app.port.domain.ExpensesCommandItem;
import com.expenses.app.port.out.SaveExpensesPort;
import org.springframework.stereotype.Component;

@Component
public class RegisterExpensesUseCase {

    private final SaveExpensesPort saveExpensesPort;

    public RegisterExpensesUseCase(final SaveExpensesPort saveExpensesPort) {
        this.saveExpensesPort = saveExpensesPort;
    }

    public void saveExpenses(final ExpensesCommandItem expensesCommand) {

        saveExpensesPort.saveExpenseRecord(expensesCommand);
    }
}
