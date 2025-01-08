package dw.com.companyapp.repository;

import dw.com.companyapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
    @Query( "select e from Employee e where e.department.id = :departmentNumber and e.position = :position")
    List<Employee> find (String departmentNumber, String position);

    @Query("select e from Employee e  where e.hireDate > :hiredate")
    List<Employee> findhiredate(LocalDate hiredate);

    @Query("select e from Employee e order by e.hireDate desc limit 1 ")
    List<Employee> findlimit();
}
