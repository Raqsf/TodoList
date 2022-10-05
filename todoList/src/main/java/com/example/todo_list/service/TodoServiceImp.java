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
		db.updateTodo(todo);
	}
}
