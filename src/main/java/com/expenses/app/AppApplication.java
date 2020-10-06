package com.expenses.app;

import com.expenses.app.domain.Expenses;
import com.expenses.app.domain.ExpensesItem;
import com.expenses.app.domain.ExpensesType;
import com.expenses.app.domain.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	@Autowired
	private ExpensesRepository expensesRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		final Expenses expenses = new Expenses();
		ExpensesItem singleExpenseData = new ExpensesItem();
		singleExpenseData.setAmount(200L);
		singleExpenseData.setExpensesType(ExpensesType.ARS);
		singleExpenseData.setName("Car expenses");
		List<ExpensesItem> items = Stream.of(singleExpenseData).collect(Collectors.toList());
		expenses.setItems(items);
		expensesRepository.save(expenses);
	}
}
