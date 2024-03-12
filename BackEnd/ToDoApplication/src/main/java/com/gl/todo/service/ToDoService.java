package com.gl.todo.service;

import java.util.List;

import com.gl.todo.dto.ToDoDTO;

public interface ToDoService {
	public ToDoDTO createTodo(ToDoDTO dto); // CRUD Operations

	public ToDoDTO getToDoById(int id);

	public ToDoDTO updateToDoById(int id, ToDoDTO dto);

	public void deleteToDoById(int id);

	public List<ToDoDTO> getAllToDo();

	public ToDoDTO completeToDoById(int id);
	
	public ToDoDTO inCompleteToDoById(int id);

}