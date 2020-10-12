package com.expenses.app.persistence.domain;

import lombok.*;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection="expensesItems")
@TypeAlias("expensesItems")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExpensesItem extends AbstractDocument {

    private Long amount;
    private String name;
    private ExpensesType expensesType;
    private LocalDateTime requestedDate;
    private LocalDateTime dueDate;

}
