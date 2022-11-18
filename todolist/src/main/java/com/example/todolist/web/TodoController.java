package com.example.todolist.web;

import com.example.todolist.domain.Todo;
import com.example.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todolist")
    public String home(Model model) {
        List<Todo> lists = todoService.searchAll();
        model.addAttribute("lists", lists);
        return "todo/todolist";
    }

    @GetMapping("/todolist/new")
    public String createForm(Model model) {
        model.addAttribute("form", new TodoForm());
        return "todo/createTodoForm";
    }
    @PostMapping("/todolist/new")
    public String createList(Model model, TodoForm form) {
        Todo todo = new Todo();
        todo.setContent(form.getContent());
        todoService.add(todo);
        return "redirect:/todolist";
    }

    @GetMapping("/todolist/{id}/edit")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        Todo todo = (Todo) todoService.searchById(id);

        TodoForm form = new TodoForm();
        form.setId(todo.getId());
        form.setContent(todo.getContent());
        form.setStatus(todo.getStatus());

        model.addAttribute("form", form);
        return "todo/updateTodoForm";
    }

    @PostMapping("/todolist/{id}/edit")
    public String updateList(@ModelAttribute("form") TodoForm form) {
        todoService.update(form.getId(), form.getContent(), form.getStatus());
        /*
        Todo todo = new Todo();
        todo.setId(form.getId());
        todo.setContent(form.getContent());
        todo.setStatus(form.getStatus());
        */
        return "redirect:/todolist";
    }


}
