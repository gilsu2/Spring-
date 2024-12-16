package com.dw.jdbcapp.service;

import com.dw.jdbcapp.model.Department;
import com.dw.jdbcapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments(){
        return departmentRepository.getAllDepartments();
    }

    // single data (저장할 데이터 객체가 1개 처리용)
    public Department saveDepartment (Department department){
        return departmentRepository.saveDepartment(department);
    }

    // multiple data (저장할 데이터가 리스트임)
    public List<Department> saveDepartmentList(List<Department>departmentList){
        for (Department data : departmentList) {
            departmentRepository.saveDepartment(data);
        }
        return departmentList;
    }

    public Department updateDepartment(Department department){
        return departmentRepository.updateDepartment(department);

    }

}
