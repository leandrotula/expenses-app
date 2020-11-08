package com.expenses.app.exceptions.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExpensesError {
    private String field;
    private Object rejectedValue;
    private String message;

    public ExpensesError(String message) {
        this.message = message;
    }

    public ExpensesError(String field, Object rejectedValue, String message) {
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}