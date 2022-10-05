package com.example.todo_list.service;

import java.util.Date;

import com.example.todo_list.model.Todo;
import com.example.todo_list.Db;

public class TodoServiceImp {
	
	public Db db = new Db();
	
	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		db.addTodo(new Todo(name, desc, targetDate, isDone));
	}
}
