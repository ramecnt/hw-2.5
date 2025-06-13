package com.example.course_work25.Department.Old;

import com.example.course_work25.Employee.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentServiceOld {
    Map<String, List<Employee>> getEmployeesByDepartment(String department);

    Map<String, List<Employee>> getAllEmployeesByDepartments();

    Employee getMaxSalary(String department);

    Employee getMinSalary(String department);
}
