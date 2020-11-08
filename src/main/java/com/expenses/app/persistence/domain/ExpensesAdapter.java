package com.expenses.app.persistence.domain;

import com.expenses.app.persistence.domain.repository.ExpensesRepository;
import com.expenses.app.port.domain.ExpensesCommandItem;
import com.expenses.app.port.out.SaveExpensesPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExpensesAdapter implements SaveExpensesPort {

    private final ExpensesRepository expensesRepository;

    @Autowired
    public ExpensesAdapter(final ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    @Override
    public void saveExpenseRecord(ExpensesCommandItem expensesCommand) {

        final Expenses expenses = Expenses.builder()
                .creationDate(expensesCommand.getRequestedDate())
                .type(expensesCommand.getExpensesType().getDescription())
                //.amount(expensesCommand.getAmount())
                .build();

        this.expensesRepository.save(expenses);

    }
}
