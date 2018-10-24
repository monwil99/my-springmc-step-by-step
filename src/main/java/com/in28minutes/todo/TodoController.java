package com.in28minutes.todo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("bagoPangalan")
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@RequestMapping(value="/list-todos", method = RequestMethod.GET)
	public String listTodos(ModelMap map) {
		
		map.addAttribute("todos", service.retrieveTodos("in28Minutes"));
		return "list-todos";
		
		//model is destroyed once redirected
		//request scope
		//session scope - from the user login and logout or the session expires
	}
	
	/*
	 * Option is to add the below add todo to a separate controller
	 */
	
	@RequestMapping(value="/add-todo", method = RequestMethod.GET)
	public String showTodoPage() {
		

		return "todo";
		
		//model is destroyed once redirected
		//request scope
		//session scope - from the user login and logout or the session expires
	}
	
	@RequestMapping(value="/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @RequestParam String desc) {
		service.addTodo("in28Minutes", desc, new Date(), false);
		/*
		 * As I dont want any session attributes to be passes as parameter in the URL.
		 * Need to clear the model
		 */
		model.clear();

		//return "list-todos"; // this will not show the current list
		return "redirect:list-todos"; 
		/*this will execute same as method listTodos including the modelMap that has the list
		of todos. Note that lists are not recommended to stay in the session*/
		
		
		
		//model is destroyed once redirected
		//request scope
		//session scope - from the user login and logout or the session expires
	}
	

}
