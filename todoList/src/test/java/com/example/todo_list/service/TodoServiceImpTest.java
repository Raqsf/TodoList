package com.example.todo_list.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.example.todo_list.model.Todo;

class TodoServiceImpTest {
	
	public TodoServiceImp todoService = new TodoServiceImp();
	
	private static Todo todo;
	
	@BeforeAll
	public static void setUp() {
		todo = new Todo("Joaquim", "Do something", new Date(1664952825), false);
	}

	@Test
	void createTodo_AddedToRepository() {
		todoService.addTodo(todo);
		assertTrue(todoService.db.containsTodo(todo));
		assertTrue(!todoService.db.getTodo(todo.getId()).get().getDescription().isEmpty());
	}
	
	@Test
	void updateTodo_AddFinalizationDate_DatesInCorrectOrder() {
		todoService.addTodo(todo);
		
		Date finalDate = new Date();
		todo.setTargetDate(finalDate);
		
		todoService.updateTodo(todo);
		
		Todo resultTodo = todoService.db.getTodo(todo.getId()).get();
		assertEquals(resultTodo.getTargetDate(), finalDate);
		assertTrue(resultTodo.getTargetDate().after(resultTodo.getCreationDate()));
	}
	
	@Test
	void updateTodo_AddFinalizationDate_DatesInIncorrectOrder() {
		todoService.addTodo(todo);
		
		Date finalDate = new Date(1664852825);
		
		assertThrows(IllegalArgumentException.class, () -> {todo.setTargetDate(finalDate);
		});
	}
	
	
	
	@Test
	void updatePriority_Task_Correct() {
		todoService.addTodo(todo);
		String priorityH = new String("High");
		String priorityM = new String("Medium");
		String priorityL = new String("Low");

		todo.setPriority(priorityH);	
		assertTrue(todoService.db.containsTodo(todo));
		assertEquals(todo.getPriority(),priorityH);
		
		todo.setPriority(priorityM);	
		assertTrue(todoService.db.containsTodo(todo));
		assertEquals(todo.getPriority(),priorityM);
		
		todo.setPriority(priorityL);	
		assertTrue(todoService.db.containsTodo(todo));
		assertEquals(todo.getPriority(),priorityL);
		
	}
	
	@Test
	void updatePriority_Task_InCorrect() {
		todoService.addTodo(todo);
		String priority = new String("Software");
		
		
		assertThrows(IllegalArgumentException.class, () -> {
			todo.setPriority(priority);
		});
		
	}
	
}
