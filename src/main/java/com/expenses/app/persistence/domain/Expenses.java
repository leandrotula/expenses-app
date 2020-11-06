package com.expenses.app.persistence.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "EXPENSES")
@NoArgsConstructor
@Builder
public class Expenses {

    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private LocalDateTime creationDate;
}
