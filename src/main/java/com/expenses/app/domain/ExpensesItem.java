package com.expenses.app.domain;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection="expensesItems")
@TypeAlias("expensesItems")
public class ExpensesItem extends AbstractDocument {

    private Long amount;
    private String name;
    private ExpensesType expensesType;
    private LocalDateTime requestedDate;
    private LocalDateTime dueDate;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExpensesType getExpensesType() {
        return expensesType;
    }

    public void setExpensesType(ExpensesType expensesType) {
        this.expensesType = expensesType;
    }

    public LocalDateTime getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(LocalDateTime requestedDate) {
        this.requestedDate = requestedDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
