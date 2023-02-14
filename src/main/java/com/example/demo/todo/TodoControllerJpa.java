package com.example.demo.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	@Autowired
	private TodoServiceUsingJpa todoServiceUsingJpa;
	public TodoControllerJpa(TodoServiceUsingJpa todoServiceUsingJpa) {
		super();
		this.todoServiceUsingJpa = todoServiceUsingJpa;
	}

	/*
	 * @Autowired private AuthenticationClass authenticate; public
	 * TodoController(AuthenticationClass authenticate) { this.authenticate =
	 * authenticate; }
	 */
	@RequestMapping("/")
	public String getHomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "Welcome";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	  @RequestMapping("list-todos") 
	  public String listAllTodos(ModelMap model,Todo todo) throws Exception{
	  List<Todo> to=todoServiceUsingJpa.getTodos(); 
	  model.put("todos", to); 
	  return "ListTodos"; 
	  }
	 
	
	/*
	 * @RequestMapping(value="/{name}",method=RequestMethod.GET) public Todo
	 * getTodoByName(@PathVariable String username) { return
	 * todoService.getTodoByName(username); }
	 */
	/*
	 * @RequestMapping(value="/login",method=RequestMethod.GET) public String
	 * getLoginPage() {
	 * 
	 * return "Login"; }
	 * 
	 * @RequestMapping(value="/login",method=RequestMethod.POST) public String
	 * getWelcomePage(@RequestParam String name,String password,ModelMap model) {
	 * if(authenticate.authenticate(name, password)) { model.put("name", name);
	 * model.put("password", password); return "Welcome"; } model.put("error",
	 * "Invalid Credentials! Please try again."); return "Login"; }
	 */
	
	@RequestMapping(value="/add-todo",method=RequestMethod.GET)
	public String getAddTodoPage(ModelMap model,Todo todo) {
		String username=(String) model.get(model);
		model.put("todo",todo);
		return "AddTodos";
	}
	
	@RequestMapping(value="/add-todo",method=RequestMethod.POST)
	public String getReturnTodoPage(ModelMap model,@Valid  Todo todo,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "AddTodos";
		}
		String username=(String) model.get("name");
		todo.setUsername(username);
		todoServiceUsingJpa.addTodos(todo);
		//todoServiceUsingJpa.addTodos(username,todo.getDescription(), todo.getTargetDate(), todo.isDone());
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="/delete-todos",method=RequestMethod.GET)
	public String getDeleteTodoPage(@RequestParam int id) throws Exception {
		todoServiceUsingJpa.deleteTodos(id);
		return "redirect:list-todos";
	}
	
	
	@RequestMapping(value="/update-todos",method=RequestMethod.GET)
	public String getUpdateTodoPage(@RequestParam int id,ModelMap model) throws Exception {
		
		Todo todo=todoServiceUsingJpa.getUpdate(id);
		model.addAttribute("todo", todo);
		return "AddTodos";
	}
	
	@RequestMapping(value="/update-todos",method=RequestMethod.POST)
	public String getUpdateReturnTodoPage(@RequestParam int id,ModelMap model,@Valid Todo todo,BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()) {
			return "AddTodos";
		}
		String username=(String) model.get("name");
		todo.setUsername(username);
		todoServiceUsingJpa.updateTodos(id,todo);
		return "redirect:list-todos";
	}
}
