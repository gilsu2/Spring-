package com.dw.jpaapp.model;

import com.dw.jpaapp.dto.StudentDTO;
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
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column (name = "name", nullable = false)
    private String name;

    @Column (name = "email",nullable = false,unique = true)
    private String email;

    @ManyToMany(mappedBy = "studentList")
    private List<Course> courseList = new ArrayList<>();

    public StudentDTO ToStudentDTO(){
        List<Long> courseIds = courseList.stream().map(Course::getId).toList();
        return new StudentDTO(this.id,this.name,this.email,courseIds);

    }


}
