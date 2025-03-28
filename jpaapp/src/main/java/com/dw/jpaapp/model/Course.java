package com.dw.jpaapp.model;

import com.dw.jpaapp.dto.CourseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table (name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor_fk;

    @ManyToMany
    @JoinTable(name = "course_student",
    joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> studentList = new ArrayList<>();

    // CourseDTO 매핑 메서드
    public CourseDTO toDTo(){
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(this.id);
        courseDTO.setTitle(this.title);
        courseDTO.setDescription(this.description);
        courseDTO.setInstructorId(this.instructor_fk.getId());
        List<Long>studentIds = new ArrayList<>();
        for(Student data : studentList){
            studentIds.add(data.getId());
        }
        courseDTO.setStudentIds(studentIds);
        return courseDTO;
    }
}
