package com.example.todolist.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor      // 파라미터가 없는 기본 생성자를 생성
@AllArgsConstructor     // 모든 필드 값을 파라미터로 받는 생성자를 만듦
@Getter @Setter
public class Todo {
    @Id  // 기본키 매핑(PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동 AUTO_INCREMENT로 id값 증가
    private long id;

    @Column(nullable = false)
    private String content;  // 내용

    @Column
    private Boolean status;  // 수행여부
}
