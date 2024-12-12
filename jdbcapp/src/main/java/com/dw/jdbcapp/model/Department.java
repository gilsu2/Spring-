package com.dw.jdbcapp.model;

public class Department {
    private String departmentNum; // 부서번호
    private String departmentName; // 부서명

    // 기본생성자
    public Department() {
    }

    public Department(String departmentNum, String departmentName) {
        this.departmentNum = departmentNum;
        this.departmentName = departmentName;
    }

    public String getDepartmentNum() {
        return departmentNum;
    }

    public void setDepartmentNum(String departmentNum) {
        this.departmentNum = departmentNum;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentNum='" + departmentNum + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
