package com.expenses.app.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "EXPENSES")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Expenses {

    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private LocalDateTime creationDate;
    private LocalDateTime DueDate;
    private Long amount;
    private String description;
}
