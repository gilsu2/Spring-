package com.dw.jpaapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "student") // 명시적으로 테이블이름 설정
public class Student {
    @Id // PK로 설정하는 어노테이션
    @GeneratedValue (strategy = GenerationType.IDENTITY) // 아이디숫자 자동 증가
    @Column (name = "id") // @Id를 사용하면 이름을 지정하지 않아도 됨
    private Long id;

    @Column (name = "name",nullable = false) // nullable = false : 반드시 입력값이 있어야 함(중복가능)
    private String name;

    @Column (name = "email", nullable = false, unique = true) // unique = true : 중복이 안됨
    private String email;

    @ManyToMany(mappedBy = "studentList")
    private List<Course> courseList = new ArrayList<>();
}
