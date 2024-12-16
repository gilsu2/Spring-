package com.dw.jdbcapp.repository;

import com.dw.jdbcapp.model.Customer;
import com.dw.jdbcapp.model.Department;
import com.dw.jdbcapp.model.Order;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DepartmentRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        String query = "select * from 부서";
        try (
                Connection connection = DriverManager.getConnection(
                        URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {
            System.out.println("데이터베이스 연결 성공");
            // 조회 결과가 resultSet에 담겨있음
            // resultSet으로부터 데이터를 꺼내서 Customer 클래스의 인스턴스를 저장
            // 생성된 인스턴스들은 List<Customer>에 추가함
            while (resultSet.next()) {
                Department department = new Department();
                {
                    department.setDepartmentNum(resultSet.getString("부서번호"));
                    department.setDepartmentName(resultSet.getString("부서명"));
                    departments.add(department);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }


    public Department saveDepartment (Department department){
            String query = "insert into 부서(부서번호, 부서명) " +
                    "values (?,?)";
            try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setString(1, department.getDepartmentNum() );
                pstmt.setString(2, department.getDepartmentName() );
                pstmt.executeUpdate();
                System.out.println("INSERT 성공");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        // 매개변수로 전달받은 department 객체 정보를 MySQL에 insert한 후
        // 성공이면 해당 객체를 리턴함
        return department;
    }

    public Department updateDepartment(Department department) {
        String query = "update 부서 set 부서명=? where 부서번호=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, department.getDepartmentName());
            pstmt.setString(2, department.getDepartmentNum());
            pstmt.executeUpdate();
            System.out.println("UPDATE 성공");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department ;
    }

}