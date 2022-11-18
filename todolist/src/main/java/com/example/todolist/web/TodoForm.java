package com.example.todolist.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoForm {

    private Long id;
    private String content;
    private Boolean status;

}
