package com.dw.jpaapp.service;


import com.dw.jpaapp.dto.CourseDTO;
import com.dw.jpaapp.dto.InstructorDTO;
import com.dw.jpaapp.dto.StudentDTO;
import com.dw.jpaapp.model.Course;
import com.dw.jpaapp.model.Instructor;
import com.dw.jpaapp.model.Student;
import com.dw.jpaapp.repository.CourseRepository;
import com.dw.jpaapp.repository.InstructorRepository;
import com.dw.jpaapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    InstructorRepository instructorRepository;
    @Autowired
    StudentRepository studentRepository;

    public List<CourseDTO> getAllCourses() {
        //map()대신 filter() 사용할 수 있음.(filter (참 또는 거짓을 리턴) 참일 경우에만 남김, 거짓이면 버림)
        return courseRepository.findAll().stream().map(Course::toDTo) //map()은 값을 변형 시키는 데에 사용 됨
                .collect(Collectors.toList());
    }

    public List<CourseDTO> getCoursesLike(String title) {
        String title1 = "%" + title + "%";
        return courseRepository.findByTitleLike(title1).stream()
                .map(Course::toDTo).toList();


    }

    public CourseDTO saveCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setTitle(courseDTO.getTitle());
        course.setDescription(courseDTO.getDescription());
        course.setInstructor_fk(instructorRepository.findById(courseDTO.getInstructorId())
                .orElseThrow(()->new RuntimeException("No instructor")));
        course.setStudentList(courseDTO.getStudentIds().stream()
                .map(id->studentRepository.findById(id))
                .map(optional->optional.orElseThrow(()->new RuntimeException("No Student")))
                .toList()
        );
        return courseRepository.save(course).toDTo();
    }
}



















