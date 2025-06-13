package com.example.course_work25.Department.New;

import com.example.course_work25.Employee.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Employee> getEmployeesByDepartment(String departmentId);

    int getSalarySumByDepartment(String departmentId);

    int getMaxSalaryByDepartment(String departmentId);

    int getMinSalaryByDepartment(String departmentId);

    Map<String, List<Employee>> getAllEmployeesGroupedByDepartment();
}
