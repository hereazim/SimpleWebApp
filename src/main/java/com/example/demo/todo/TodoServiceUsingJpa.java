package com.example.demo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.*;
@Service
public class TodoServiceUsingJpa  {
	@Autowired
	TodoRepository todoRepository;
	public TodoServiceUsingJpa(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}
	List<Todo> todoList=new ArrayList<>();
	
	public void addTodos(Todo todo) {
		Todo todo1=todoRepository.save(todo);
		todoList.add(todo1);
	}
	
	
	public List<Todo> getTodos() throws Exception{
		return todoRepository.findAll();
	}
	
	
	public void updateTodos(int id,Todo todo) throws Exception{
		for(int i=0;i<todoList.size();i++) {
			if(todoList.get(i).getId()==id) {
				Todo t=todoRepository.save(todo);
				todoList.set(i, t);
				}
			}		
		}
	 
	
	


	public Todo  getUpdate(int id) {
		Todo t=null;
		for(int i=0;i<todoList.size();i++) {
			if(todoList.get(i).getId()==id) {
				t=todoList.get(i);
			}
			}
		return t;
	}

	public void deleteTodos(int id) throws Exception{
		 for(int i=0;i<todoList.size();i++) {
			  if(todoList.get(i).getId()==id) {
				  todoRepository.deleteById(id);
				  todoList.remove(i);
			  }
		 }
	}
	

}
