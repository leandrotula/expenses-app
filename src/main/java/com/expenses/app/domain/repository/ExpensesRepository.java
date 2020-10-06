package com.expenses.app.domain.repository;

import com.expenses.app.domain.Expenses;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpensesRepository extends MongoRepository<Expenses, Long> {
}
