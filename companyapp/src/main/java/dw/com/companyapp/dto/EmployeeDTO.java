package dw.com.companyapp.dto;

import dw.com.companyapp.model.Department;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class EmployeeDTO {

    private String employeeId;

    private String name;

    private String englishName;

    private String position;

    private String gender;

    private LocalDate birthDate;

    private LocalDate hireDate;

    private String address;

    private String city;

    private String region;

    private String phoneNumber;

    private String supervisorId;

    private Department departmentName;
}
