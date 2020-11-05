package com.expenses.app.persistence.domain;

import com.expenses.app.persistence.domain.repository.ExpensesRepository;
import com.expenses.app.port.domain.ExpensesCommandItem;
import com.expenses.app.port.out.SaveExpensesPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ExpensesPersistenceAdapter implements SaveExpensesPort {

    private ExpensesRepository expensesRepository;

    @Override
    public void saveExpenseRecord(final ExpensesCommandItem commandItem) {

         final ExpensesItem expenses = ExpensesItem.builder()
                .amount(commandItem.getAmount())
                .dueDate(commandItem.getDueDate())
                .requestedDate(commandItem.getRequestedDate())
                .name(commandItem.getName())
                .build();

        log.info("About to save expense item {}", expenses);

        this.expensesRepository.save(expenses);

    }

    @Autowired
    public void setExpensesRepository(final ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }
}
