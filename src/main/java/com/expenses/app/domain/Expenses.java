package com.expenses.app.domain;

import java.util.List;

public class Expenses {

    private List<ExpensesItem> items;

    public List<ExpensesItem> getItems() {
        return items;
    }

    public void setItems(List<ExpensesItem> items) {
        this.items = items;
    }
}
