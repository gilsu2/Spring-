package dw.com.companyapp.model;

import dw.com.companyapp.dto.EmployeeDTO;
import dw.com.companyapp.dto.EmployeeDepartmentDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="사원")
public class Employee {
    @Id
    @Column(name="사원번호")
    private String employeeId;
    @Column(name="이름")
    private String name;
    @Column(name="영문이름")
    private String englishName;
    @Column(name="직위")
    private String position;
    @Column(name="성별")
    private String gender;
    @Column(name="생일")
    private LocalDate birthDate;
    @Column(name="입사일")
    private LocalDate hireDate;
    @Column(name="주소")
    private String address;
    @Column(name="도시")
    private String city;
    @Column(name="지역")
    private String region;
    @Column(name="집전화")
    private String phoneNumber;
    @Column(name="상사번호")
    private String supervisorId;
    @ManyToOne
    @JoinColumn(name = "부서번호")
    private Department department;

    public EmployeeDepartmentDTO ToDTO(){
        EmployeeDepartmentDTO employeeDepartmentDTO = new EmployeeDepartmentDTO();
        employeeDepartmentDTO.setEmployeeName(this.name);
        employeeDepartmentDTO.setHireDate(this.hireDate);
        if (this.department != null) {
            employeeDepartmentDTO.setDepartmentName(this.department.getDepartmentName());
        } else {
            employeeDepartmentDTO.setDepartmentName("Unknown");
}
        return employeeDepartmentDTO;


    }
    public EmployeeDTO TODTO(){
       EmployeeDTO employeeDTO = new EmployeeDTO();
       employeeDTO.setEmployeeId(this.getEmployeeId());
       employeeDTO.setName(this.getName());
       employeeDTO.setEnglishName(this.getEnglishName());
       employeeDTO.setPosition(this.getPosition());
       employeeDTO.setGender(this.getGender());
       employeeDTO.setBirthDate(this.getBirthDate());
       employeeDTO.set
    }
}
