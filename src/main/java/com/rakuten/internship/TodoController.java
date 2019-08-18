package com.rakuten.internship;

import com.rakuten.internship.entity.Todo;
import com.rakuten.internship.service.TodoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * このクラスは、ウェブアプリケーションの挙動を制御するためのコントローラークラスです。。
 * コントローラーとして使えるように、コードを記入してください。
 */
@Controller
public class TodoController {

    @Autowired
    private TodoService service;

    private Logger logger = LoggerFactory.getLogger(TodoController.class);

    @GetMapping("/")
    public String home(Model model) {
        logger.info("GET /");
        List<Todo> todos = service.findTodos();
        model.addAttribute("todos", todos);
        return "home";
    }

    @GetMapping("/create")
    public String create(Todo todo) {
        logger.info("GET /create");
        return "create";
    }

    @PostMapping("/create")
    public String createTodo(@ModelAttribute Todo todo) {
        logger.info("POST /create");
        logger.info("Todo recibido: " + todo.toString());
        service.save(todo);
        return "complete";
    }
}
