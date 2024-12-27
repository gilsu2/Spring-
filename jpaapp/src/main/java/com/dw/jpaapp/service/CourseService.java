package com.dw.jpaapp.service;


import com.dw.jpaapp.dto.CourseDTO;
import com.dw.jpaapp.model.Course;
import com.dw.jpaapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public List<CourseDTO> getAllCourses() {
        //map()대신 filter() 사용할 수 있음.(filter (참 또는 거짓을 리턴) 참일 경우에만 남김, 거짓이면 버림)
        return courseRepository.findAll().stream().map(Course::toDTo) //map()은 값을 변형 시키는 데에 사용 됨
                .collect(Collectors.toList());
    }
}
