package com.example.course_work25;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Map<String, List<Employee>> getEmployeesByDepartment(String department);

    Map<String, List<Employee>> getAllEmployeesByDepartments();

    Employee getMaxSalary(String department);

    Employee getMinSalary(String department);
}
