package com.demo.practice;

import java.util.Arrays;
import java.util.List;

public class TodoService {

	List<Todo> getTodoList() {

		return Arrays.asList(new Todo("Prapare Resume"), new Todo("Learn Spring"), new Todo("Learn JSP & Servlet"),
				new Todo("Hibernate Handson"));
	}
}
