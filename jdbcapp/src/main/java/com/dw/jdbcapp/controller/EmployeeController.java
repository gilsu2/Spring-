package com.dw.jdbcapp.controller;

import com.dw.jdbcapp.dto.EmployeeDepartmentDTO;
import com.dw.jdbcapp.model.Employee;
import com.dw.jdbcapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/find-all-employees")
    public List<Employee>getAllEmployees(){
        return employeeService.getAllEmployees();

    }
    // Query Parameters (쿼리 문자열)
    @GetMapping("/employee")
    public Employee getEmployeesById(@RequestParam String id){
        return employeeService.getEmployeesById(id);
    }
    // Path Parameters (경로 매개변수)
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById_2(@PathVariable String id){
        return employeeService.getEmployeesById(id);
    }
    @GetMapping("/employee/department")
    public List<Map<String,Object>>getEmployeesWhitDepartmentName(){
        return employeeService.getEmployeesWhitDepartmentName();
    }
    @GetMapping("/employee/department2")
    public List<EmployeeDepartmentDTO>getEmployeesWhitDepartmentName2(){
        return employeeService.getEmployeesWhitDepartmentName2();
    }


    @GetMapping("/api/employees/{id}/{po}")
    public Employee getEmployeesWhitDepartmentName3(@PathVariable String id,@PathVariable String po){
        return employeeService.getEmployeesWhitDepartmentName3(id, po);
    }
    @GetMapping("/api/employees")
    public Employee getEmployeesWhitDepartmentName_3(@RequestParam String id,@RequestParam String po){
        return employeeService.getEmployeesWhitDepartmentName3(id,po);
    }
}
