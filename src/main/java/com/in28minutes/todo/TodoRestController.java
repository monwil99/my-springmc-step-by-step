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

	/*The @RestController annotation in Spring MVC is nothing but a combination of the @Controller and the 
	 * @ResponseBody annotation. It was added into Spring 4.0 to make the development of RESTful Web Services 
	 * in Spring framework easier. If you are familiar with the REST web services you know that the fundamental 
	 * difference between a web application and a REST API is that the response from a web application is a generally
	 *  view of HTML + CSS + JavaScript while REST API just return data in form of JSON or XML. This difference is also
	 *   obvious in the @Controller and the @RestController annotation. The job of the @Controller is to create a Map of 
	 *   model object and find a view but the @RestController simply returns the object and object data is directly written 
	 *   into HTTP response as JSON or XML.*/
	
/*	@Controller
	@ResponseBody
	public class MVCController {
	   .. your logic

	@RestController
	public class RestFulController { 
	  .... your logic
	}*/
}
