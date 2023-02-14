/*
 * package com.example.demo.todo;
 * 
 * import java.time.LocalDate; import java.util.ArrayList; import
 * java.util.List;
 * 
 * import org.springframework.stereotype.Service;
 * 
 * import jakarta.validation.Valid;
 * 
 * @Service public class TodoService { private static List<Todo> todoList=new
 * ArrayList(); static int todoId=0; static { todoList.add(new
 * Todo(++todoId,"Ramesh","Learn RestAPI",LocalDate.now(),false));
 * todoList.add(new
 * Todo(++todoId,"Ajith","AWS Fundamentals",LocalDate.now(),false));
 * todoList.add(new
 * Todo(++todoId,"Mohan","Start with Devops",LocalDate.now(),false)); }
 * 
 * public List<Todo> getAllTodoDetails(){ return todoList; }
 * 
 * 
 * public Todo getTodoByName(String name) { for(Todo t:todoList) {
 * if(t.getUsername().equalsIgnoreCase(name)) { return t; } } return null; }
 * 
 * 
 * public void addTodos(String username,String description,LocalDate
 * targetDate,boolean done) { Todo todo=new
 * Todo(++todoId,username,description,targetDate,done); todoList.add(todo); }
 * 
 * public void deleteTodos(int id) { for(int i=0;i<todoList.size();i++){
 * if(todoList.get(i).getId()==id) { todoList.remove(i); } } }
 * 
 * public Todo updateTodos(int id) { Todo todo = null; for(int
 * i=0;i<todoList.size();i++){ if(todoList.get(i).getId()==id) {
 * todo=todoList.get(i); } } return todo; }
 * 
 * 
 * public void updateTodos2(@Valid Todo todo) { deleteTodos(todo.getId());
 * todoList.add(todo); } }
 */