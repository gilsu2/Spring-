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
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column (name = "title",nullable = false)
    public String title;

    @Column (name = "description")
    public String description;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    public Instructor instructor_fk;

    @ManyToMany
    @JoinTable (name = "course_student",
            joinColumns = @JoinColumn(name = "course id"),
    inverseJoinColumns = @JoinColumn(name= "student_id"))
    private List<Student> studentList = new ArrayList<>();
}