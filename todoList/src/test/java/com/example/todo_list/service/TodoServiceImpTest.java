package com.example.todo_list.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.example.todo_list.controller.TodoController;
import com.example.todo_list.model.Todo;
import com.example.todo_list.repository.TodoRepository;

class TodoServiceImpTest {
	
	public TodoServiceImp todoService;
	
	private static Todo todo;
	
	@BeforeAll
	public static void setUp() {
		todo = new Todo("Joaquim", "Do something", new Date(), false);
	}

	@Test
	void createTodo_AddedToRepository() {
		todoService.addTodo(todo.getUserName(), todo.getDescription(), todo.getTargetDate(), false);
		assertTrue(todoService.db.containsTodo(todo));
		assertTrue(todoService.db.getTodo(todo).get().getDescription().isEmpty());
	}
	
}
