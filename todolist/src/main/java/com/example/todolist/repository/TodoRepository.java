package com.example.todolist.repository;

import com.example.todolist.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodoRepository {

    private final EntityManager em;

    public void save(Todo todo) {
        em.persist(todo);  // todo 객체를 영속 상태로 변경
    }

    public Todo findOne(Long id) {
        return em.find(Todo.class, id);
    }

    public List<Todo> findAll() {
        return em.createQuery("select t from Todo t", Todo.class)
                .getResultList();
    }

    public void deleteOne(Long id) {
        Todo findTodo = em.find(Todo.class, id);
        em.remove(findTodo);
    }

    public void deleteAll(List<Todo> todo) {
        em.remove(todo);
    }

}
