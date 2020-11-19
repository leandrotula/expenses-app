package com.expenses.app.persistence.domain.repository;

import com.expenses.app.persistence.domain.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpensesRepository extends JpaRepository<Expenses, String> {

    Optional<Expenses> getById(final String id);
}
