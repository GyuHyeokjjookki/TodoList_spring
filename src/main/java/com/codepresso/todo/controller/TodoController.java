package com.codepresso.todo.controller;

import java.util.List;

import com.codepresso.todo.service.TodoService;
import com.codepresso.todo.vo.ResultDto;
import com.codepresso.todo.vo.Todo;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class TodoController {

    //todo TodoService를 활용하기 위한 의존성 주입 코드
    private final TodoService todoService;

    public TodoController(TodoService todoService) {this.todoService = todoService; }

    @GetMapping("/todo")
    @ResponseBody
    public List<Todo> getTodoList(){
        List<Todo> list = todoService.getTodoList();
        return list;
    }

    @PostMapping("/todo")
    @ResponseBody
    public ResultDto addTodo(HttpServletResponse response, @RequestBody Todo todoParam) {
        Todo todo = new Todo(todoParam.getContent());
        todoService.addTodo(todo);

        response.setStatus(HttpServletResponse.SC_OK);
        return new ResultDto(200, "Success");
    }

    @DeleteMapping("/todo/{id}")
    public ResultDto deleteTodo(HttpServletResponse response,@PathVariable("id") String id) {
        todoService.deleteTodo(Integer.parseInt(id));

        response.setStatus(HttpServletResponse.SC_OK);
        return new ResultDto(200, "Success");
    }

}
