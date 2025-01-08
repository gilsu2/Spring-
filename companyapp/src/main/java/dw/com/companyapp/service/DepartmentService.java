package dw.com.companyapp.service;


import dw.com.companyapp.model.Department;
import dw.com.companyapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department saveDepartment(Department department) {
        Department department1 = new Department();
        department1.setDepartmentId(department.getDepartmentId());
        department1.setDepartmentName(department.getDepartmentName());

        return departmentRepository.save(department);
    }

    public List<Department> saveDepartmentList(List<Department> departmentList) {
        List<Department> departments = new ArrayList<>();
        for (Department data : departmentList) {
             Department department= departmentRepository.save(data);
             departments.add(department);
        }
        return departments;
    }

    public Department updateDepartment(Department department) {
       Department department1 = departmentRepository.findById(department.getDepartmentId())
                .orElseThrow(()-> new RuntimeException("NOT FOUND"));
        department1.setDepartmentId(department.getDepartmentId());
        department1.setDepartmentName(department.getDepartmentName());
        return departmentRepository.save(department);
    }

    public String deleteDepartment(String id) {
        Department department = departmentRepository.findById(id).
                orElseThrow(()-> new RuntimeException("NOT FOUND"));
        departmentRepository.delete(department);
        return id;
    }
}








