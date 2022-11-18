package com.example.todolist.service;

import com.example.todolist.domain.Todo;
import com.example.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)  // 트랜잭션, 영속성 컨텍스트로 해당 파라미터는 데이터 변경이 없는 읽기 전용 메서드에 사용
@RequiredArgsConstructor  // 필드 주입 대신 생성자 주입을 사용하여 변경 불가능한 안전한 객체 생성하기
public class TodoService {

    private final TodoRepository todoRepository;
    // final 키워드를 추가하여 컴파일 시점에 todoRepository를 설정하지 않는 오류를 체크 할 수 있음(보통 기본 생성자를 추가할 때 발견)

    // 할일 리스트 추가
    public Long add(Todo todo) {
        todoRepository.save(todo);
        return todo.getId();
    }

    // 할일 리스트 목록 전체 조회
    public List<Todo> searchAll() {
        return todoRepository.findAll();
    }

    // 할일 리스트 중 특정 리스트 조회
    public Todo searchById(Long id) {
        return todoRepository.findOne(id);
    }

    // 할일 리스트 중 특정 리스트 수정
    @Transactional
    public void update(long id, String content, boolean status) {
        Todo todo = todoRepository.findOne(id);
        todo.setContent(content);
        todo.setStatus(status);
    }
    // 할일 리스트 목록 전체 삭제
    public void deleteAll(List<Todo> todo) {
        todoRepository.deleteAll(todo);
    }
    // 할일 리스트 중 특정 리스트 삭제
    public void deleteById(Long id) {
        todoRepository.deleteOne(id);
    }
}
