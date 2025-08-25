package com.example.springkadaitodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.service.ToDoService;

@Controller
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    // 要件：/todo アクセスで一覧表示
    @GetMapping("/todo")
    public String showList(Model model) {
        model.addAttribute("todos", toDoService.getAll());
        return "todoView"; // → templates/todoView.html
    }
}
