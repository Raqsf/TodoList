package com.example.todo_list;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.todo_list.model.Todo;

public class Db {
	
	private List<Todo> todos = new ArrayList<>();
	
	public void addTodo(Todo todo) {
		todos.add(todo);
	}
	
	public boolean containsTodo(Todo todo) {
		return todos.contains(todo);
	}
	
	public Optional<Todo> getTodo(long id) {
		for(Todo t: todos) {
			if(t.getId() == id) {
				return Optional.of(t);
			}
		}
		return Optional.empty();
	}
	
	public void updateTodo(Todo todo) {
		int index = todos.indexOf(todo);
		if(index >= 0) {
			todos.set(index, todo);
		}
	}

	public void updatePriority(Todo todo) {
		int index = todos.indexOf(todo);
		if((index >= 0 ) && (index <= 5)) {
			todos.set(index, todo);
		}
		
	}
}
