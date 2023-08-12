package com.codepresso.todo.service;

import java.util.List;

import com.codepresso.todo.mapper.TodoMapper;
import com.codepresso.todo.vo.Todo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private TodoMapper todoMapper;

    public TodoService(TodoMapper todoMapper){
        this.todoMapper = todoMapper;
    }

    public void addTodo(Todo todo){
        todo.setIsCompleted("N");
        todoMapper.save(todo);
    }

    public List<Todo> getTodoList(){
        return todoMapper.findAll();
    }

    public void deleteTodo(int id) {
        todoMapper.delete(id);
    }
}
