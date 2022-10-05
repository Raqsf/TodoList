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
	
	public Optional<Todo> getTodo(Todo todo) {
		for(Todo t: todos) {
			if(t.equals(todo)) {
				return Optional.of(todo);
			}
		}
		return Optional.empty();
	}
}
