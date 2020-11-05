package com.expenses.app.persistence.domain;

public enum ExpensesType {
    USD("usd"), ARS("ars");

    private final String description;

    ExpensesType(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
