package com.dw.jpaapp.model;

import com.dw.jpaapp.dto.InstructorDTO;
import com.dw.jpaapp.dto.StudentDTO;
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
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name ="name",nullable = false)
    private String name;

    @Column(name = "career")
    private String career;

    @OneToMany(mappedBy = "instructor_fk")
    private List<Course> courseList
            = new ArrayList<>();

    public InstructorDTO ToInstructorDTO() {
        List<Long> courseIds = courseList.stream().map(Course::getId).toList();
        return new InstructorDTO(this.id,this.name,this.career,courseIds);

    }

}
