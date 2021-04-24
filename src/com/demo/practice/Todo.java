package com.demo.practice;

public class Todo {

	String name;

	public Todo(String name) {
		this.name = name;

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Todo [name=" + name + "]";
	}
}
