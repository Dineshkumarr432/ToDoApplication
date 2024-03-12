package com.gl.todo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.todo.dto.ToDoDTO;
import com.gl.todo.entity.ToDo;
import com.gl.todo.exception.ResourceNotFoundException;
import com.gl.todo.mapper.ToDoMapper;
import com.gl.todo.repository.ToDoRepository;
import com.gl.todo.service.ToDoService;

@Service
public class ToDoServiceImpl implements ToDoService {

	@Autowired
	ToDoRepository repository;

	@Override
	public ToDoDTO createTodo(ToDoDTO dto) {
		ToDo savetodo = ToDoMapper.mapToToDo(dto);
		return ToDoMapper.mapToTodoDTO(repository.save(savetodo));
	}

	@Override
	public ToDoDTO getToDoById(int id) {
		ToDo gettodo =repository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Given Id is not found"));
	return ToDoMapper.mapToTodoDTO(gettodo);
	}

	@Override
	public ToDoDTO updateToDoById(int id, ToDoDTO dto) {
		ToDo updatetodo = null;
		updatetodo = repository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Given Id is not found"));
		updatetodo.setTitle(dto.getTitle());
		updatetodo.setDescription(dto.getDescription());
		updatetodo.setCompleted(dto.isCompleted());
		return ToDoMapper.mapToTodoDTO(repository.save(updatetodo));
	}

	@Override
	public void deleteToDoById(int id) {
		ToDo deleteToDo = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Given Id is Not Found"));
		repository.deleteById(id);
	}

	@Override
	public List<ToDoDTO> getAllToDo() {
		List<ToDo> list = repository.findAll();
		return list.stream().map((todo)->ToDoMapper.mapToTodoDTO(todo)).collect(Collectors.toList());
	}

	@Override
	public ToDoDTO completeToDoById(int id) {
		ToDo completetodo = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Given ToDo list is not found"));
		completetodo.setCompleted(true);
		repository.save(completetodo);
		return ToDoMapper.mapToTodoDTO(completetodo);
	}

	@Override
	public ToDoDTO inCompleteToDoById(int id) {
		ToDo incompleteTodo = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Given ToDo list is not found"));
		incompleteTodo.setCompleted(false);
		repository.save(incompleteTodo);
		return ToDoMapper.mapToTodoDTO(incompleteTodo);
	}


}
