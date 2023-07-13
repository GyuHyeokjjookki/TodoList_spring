package com.codepresso.todo.service;

import java.util.List;

import com.codepresso.todo.vo.Todo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private List<Todo> todoList;

    public TodoService(List<Todo> todoList) {this.todoList = todoList;}
    //todo 멤버 변수 todoList에 의존성 주입을 하기 위한 코드

    public void addTodo(Todo todo) {
        todo.setId(todoList.size());
        todoList.add(todo);
    }

    public List<Todo> getTodoList(){
        return todoList;
    }

    public void deleteTodo(int index) {
        todoList.remove(index);
    }
}
