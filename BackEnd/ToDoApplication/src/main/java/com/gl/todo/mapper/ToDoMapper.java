package com.gl.todo.mapper;

import com.gl.todo.dto.ToDoDTO;
import com.gl.todo.entity.ToDo;

public class ToDoMapper {
	
	public static ToDoDTO mapToTodoDTO(ToDo todo) {
		ToDoDTO dto = new ToDoDTO(todo.getId(),todo.getTitle(),todo.getDescription(),todo.isCompleted());
		return dto;
	}
	
	public static ToDo mapToToDo(ToDoDTO dto) {
		ToDo todo = new ToDo(dto.getId(),dto.getTitle(),dto.getDescription(),dto.isCompleted());
		return todo;
	}
}