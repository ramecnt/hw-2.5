package com.example.course_work25.Employee;

import java.util.Collection;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int salary, String department);

    Employee deleteEmployee(String firstName, String lastName);

    Employee getEmployee(String firstName, String lastName);

    Collection<Employee> getAllEmployees();

    Map<String, Employee> getAllEmployeesMap();
}
