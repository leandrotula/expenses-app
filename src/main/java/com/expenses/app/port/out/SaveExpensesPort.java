package com.expenses.app.port.out;

import com.expenses.app.port.domain.ExpensesCommandItem;

public interface SaveExpensesPort {

    void saveExpenseRecord(final ExpensesCommandItem expensesCommand);
}
