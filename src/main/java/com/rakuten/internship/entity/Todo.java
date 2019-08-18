package com.rakuten.internship.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * このクラスは、タスク管理の対象となるTodoのエンティティーです。
 * エンティティーとして使えるように、コードを記入してください。
 */

@Data
@Entity
@Table(name = "TODO")
public class Todo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
}