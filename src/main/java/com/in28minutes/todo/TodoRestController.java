package com.in28minutes.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.todo.TodoService;

@RestController
public class TodoRestController {
	
	@Autowired
	TodoService service;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public List<Todo> retrieveAllTodos(){
		return service.retrieveTodos("in28Minutes");
	}

	@RequestMapping(value = "/todos/{id}", method = RequestMethod.GET)
	public Todo retrieveAllTodos(@PathVariable int id){
		return service.retrieveTodo(id);
	}

}
