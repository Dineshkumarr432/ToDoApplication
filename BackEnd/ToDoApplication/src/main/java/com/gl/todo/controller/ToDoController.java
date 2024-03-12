package com.gl.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.todo.dto.ToDoDTO;
import com.gl.todo.entity.ToDo;
import com.gl.todo.serviceImpl.ToDoServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/todo")
public class ToDoController {
	
	@Autowired
	ToDoServiceImpl todoService;
	
	// Build to Create or Add ToDo REST API
	@PostMapping
	public ResponseEntity<ToDoDTO> createToDo(@RequestBody ToDoDTO dto){
		todoService.createTodo(dto);
		return new ResponseEntity<>(dto,HttpStatus.CREATED);
	}
	
	// Build to get ToDo by id REST API
	@GetMapping("{id}")
	public ResponseEntity<ToDoDTO> getToDoById(@PathVariable("id") int id){
		ToDoDTO getToDo = todoService.getToDoById(id);
		return new ResponseEntity<>(getToDo,HttpStatus.OK);
	}
	
	// Build to update ToDo by id REST API
	@PutMapping("{id}")
	public ResponseEntity<ToDoDTO> updateToDoById(@PathVariable("id") int id,@RequestBody ToDoDTO dto){
		ToDoDTO updateToDo = todoService.updateToDoById(id, dto);
		return new ResponseEntity<>(updateToDo,HttpStatus.OK);
	}
	
	// Build to delete ToDo by id REST API
	@DeleteMapping("{id}")
	ResponseEntity<ToDo> deleteToDoById(@PathVariable("id") int id){
		todoService.deleteToDoById(id);
		return new ResponseEntity("Given that ToDo with ID has been deleted successfully.",HttpStatus.OK);
	}
	
	// Build to get all ToDo REST API
	@GetMapping
	ResponseEntity<List<ToDoDTO>> getAllToDoById(){
		List<ToDoDTO> list = todoService.getAllToDo();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	// Build to make complete ToDo REST API
	@PutMapping("{id}/complete")
	ResponseEntity<ToDoDTO> completeToDoById(@PathVariable("id") int id){
		ToDoDTO completetodo = todoService.completeToDoById(id);
		return new ResponseEntity<>(completetodo,HttpStatus.OK);
	}
	
	// Build to make incomplete ToDo REST API
	@PutMapping("{id}/inComplete")
	ResponseEntity<ToDoDTO> inCompleteToDoById(@PathVariable("id") int id){
		ToDoDTO inCompletetodo = todoService.inCompleteToDoById(id);
		return new ResponseEntity<>(inCompletetodo,HttpStatus.OK);
	}

}
