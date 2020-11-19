package com.expenses.app.persistence.domain;

import com.expenses.app.exceptions.custom.RecordPresentException;
import com.expenses.app.persistence.domain.repository.ExpensesRepository;
import com.expenses.app.port.domain.ExpensesCommandItem;
import com.expenses.app.port.out.SaveExpensesPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ExpensesAdapter implements SaveExpensesPort {

    private final ExpensesRepository expensesRepository;

    @Autowired
    public ExpensesAdapter(final ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    @Override
    public void saveExpenseRecord(final ExpensesCommandItem expensesCommand) {

        validateDuplicateRecord(expensesCommand);

        final Expenses.ExpensesBuilder builder = Expenses.builder();

        if (expensesCommand.getRequestedDate() ==  null) {

            builder.creationDate(LocalDateTime.now());
        } else {
            builder.creationDate(expensesCommand.getRequestedDate());
        }

        builder
                .type(expensesCommand.getExpensesType().getDescription())
                .id(expensesCommand.getId())
                .amount(expensesCommand.getAmount())
                .DueDate(expensesCommand.getDueDate())
                .description(expensesCommand.getName())
                .build();

        this.expensesRepository.save(builder.build());

    }

    private void validateDuplicateRecord(final ExpensesCommandItem expensesCommand) {

        expensesRepository.getById(expensesCommand.getId()).ifPresent(value -> {
            throw new RecordPresentException(String.format("Record %s was already present in the db ", value.getDescription()));
        });
    }
}
