package com.expenses.app.port.domain;

import com.expenses.app.persistence.domain.ExpensesType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ExpensesCommandItem {

    @NotNull(message = "id is mandatory")
    private String id;

    @NotNull(message = "amount is mandatory")
    private Long amount;

    @NotNull(message = "name is mandatory")
    @Size(max = 10)
    private String name;

    @JsonProperty("type")
    @NotNull(message = "a type must be provided")
    private ExpensesType expensesType;

    @JsonProperty("requested_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    private LocalDateTime requestedDate;

    @JsonProperty("due_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    @NotNull(message = "Due Date is mandatory")
    private LocalDateTime dueDate;
}
