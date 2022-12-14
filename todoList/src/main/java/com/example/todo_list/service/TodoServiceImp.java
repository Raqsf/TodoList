package com.example.todo_list.service;

import java.util.Date;

import com.example.todo_list.model.Todo;
import com.example.todo_list.Db;

public class TodoServiceImp {
	
	public Db db = new Db();
	
	public void addTodo(Todo todo) {
		db.addTodo(todo);
	}
	
	public void updateTodo(Todo todo) {
		try {
			db.updateTodo(todo);
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}
	
	public void updatePriority(Todo todo) {
		try {
			db.updatePriority(todo);
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}
}
