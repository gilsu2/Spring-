package dw.com.companyapp.repository;

import dw.com.companyapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
    @Query( "select e from Employee e where e.department = :departmentNumber and e.position = :position")
    List<Employee> find (String departmentNumber, String position);
}
