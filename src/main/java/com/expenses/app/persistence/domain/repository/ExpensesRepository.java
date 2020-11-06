package com.expenses.app.persistence.domain.repository;

import com.expenses.app.persistence.domain.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensesRepository extends JpaRepository<Long, Expenses> {
}
