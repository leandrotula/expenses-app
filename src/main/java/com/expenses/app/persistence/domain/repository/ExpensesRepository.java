package com.expenses.app.persistence.domain.repository;

import com.expenses.app.persistence.domain.ExpensesItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpensesRepository extends MongoRepository<ExpensesItem, Long> {
}
