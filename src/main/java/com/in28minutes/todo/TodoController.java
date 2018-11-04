package com.in28minutes.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("bagoPangalan")
public class TodoController {
	
	@Autowired
	TodoService service;
	
	/*This will be invoke before any start of controller
	 *Across all controllers, we have unified format of Date
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value="/list-todos", method = RequestMethod.GET)
	public String listTodos(ModelMap map) {
		
		map.addAttribute("todos", service.retrieveTodos(retrieveLoggedInUserName()));
		return "list-todos";
		
		//model is destroyed once redirected
		//request scope
		//session scope - from the user login and logout or the session expires
	}

	private String retrieveLoggedInUserName() {
		return "in28Minutes";
	}
	
	/*
	 * Option is to add the below add todo to a separate controller
	 */
	
	@RequestMapping(value="/add-todo", method = RequestMethod.GET)
	public String showTodoPage(ModelMap model) {
		// add object for Todo initially for form-binding, as the command object is available already in jsp, same goes here
		model.addAttribute("todo", new Todo(0, retrieveLoggedInUserName(), "Default Desc", new Date(), false));

		return "todo";
		
		//model is destroyed once redirected
		//request scope
		//session scope - from the user login and logout or the session expires
	}
	
	@RequestMapping(value="/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		// @Valid - triggers the validation for Todo bean
		service.addTodo(retrieveLoggedInUserName(), todo.getDesc(), new Date(), false);
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
	
	
	@RequestMapping(value="/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam int id) {
		service.deleteTodo(id);
		model.clear();

		return "redirect:list-todos"; 
	}
	
	@RequestMapping(value="/update-todo", method = RequestMethod.GET)
	public String updateTodo(ModelMap model, @RequestParam int id) {
		Todo todo = service.retrieveTodo(id);
		model.addAttribute("todo",todo);

		return "todo"; 
	}
	
	@RequestMapping(value="/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		
		todo.setUser(retrieveLoggedInUserName()); //TODO:Remove Hardcoding Later
		service.updateTodo(todo);

		return "redirect:list-todos"; 
	}
	

	

}
