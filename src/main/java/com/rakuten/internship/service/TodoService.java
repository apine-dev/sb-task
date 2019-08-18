package com.rakuten.internship.service;

import java.util.ArrayList;
import java.util.List;

import com.rakuten.internship.entity.Todo;
import com.rakuten.internship.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * このクラスは、データベースとのトランザクションをサポートするサービスクラスです。。
 */
@Service
@Transactional
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    private Logger logger = LoggerFactory.getLogger(TodoService.class);

    public List<Todo> findTodos(){
        logger.info("Find Todos");
        return todoRepository.findAll();
    }

    public Todo save(Todo todo) {
        logger.info("Save Todo");
        return todoRepository.save(todo);
    }
}