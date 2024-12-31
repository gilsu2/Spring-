package com.dw.jpaapp.service;

import com.dw.jpaapp.dto.InstructorDTO;
import com.dw.jpaapp.dto.StudentDTO;
import com.dw.jpaapp.model.Course;
import com.dw.jpaapp.model.Instructor;
import com.dw.jpaapp.model.Student;
import com.dw.jpaapp.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstructorService {
    @Autowired
    InstructorRepository instructorRepository;

    public List<InstructorDTO> getAllInstructors(){
        return instructorRepository.findAll().stream().map(Instructor::ToInstructorDTO).collect(Collectors.toList());
    }

    public InstructorDTO getInstructor(Long id) {
        return instructorRepository
                .findById(id)
                .map(Instructor::ToInstructorDTO)
                .orElseThrow(()->new RuntimeException("없는 아이디"));
    }
    public InstructorDTO saveInstructor(InstructorDTO instructorDTO) {
        Instructor instructor = new Instructor();
        instructor.setName(instructorDTO.getName());
        instructor.setCareer(instructorDTO.getCareer());
        List<Course> courseList = new ArrayList<>();
        for (Long id : instructorDTO.getCourseIds()) {
            courseList.add(courseRepository.findById(id)
                    .map(course->{
                        course.setInstructor_fk(instructor);
                        return course;
                    })
                    .orElseThrow(()->new RuntimeException("없는 강의아이디")));
        }
        instructor.setCourseList(courseList);
        return instructorRepository.save(instructor).toDTO();
    }

}


