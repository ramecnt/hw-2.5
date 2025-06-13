package com.example.course_work25.Department.Old;

import com.example.course_work25.Employee.Employee;
import com.example.course_work25.Employee.EmployeeService;
import com.example.course_work25.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceOldImpl implements DepartmentServiceOld {
    private final EmployeeService employeeService;

    public DepartmentServiceOldImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Map<String, List<Employee>> getAllEmployeesByDepartments() {
        return employeeService.getAllEmployees()
                .stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public Map<String, List<Employee>> getEmployeesByDepartment(String department) {
        return employeeService.getAllEmployees()
                .stream()
                .filter(e -> Objects.equals(e.getDepartment(), department))
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public Employee getMaxSalary(String department) {
        return employeeService.getAllEmployees()
                .stream()
                .filter(e -> Objects.equals(e.getDepartment(), department))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException(")"));
    }

    public Employee getMinSalary(String department) {
        return employeeService.getAllEmployees()
                .stream()
                .filter(e -> Objects.equals(e.getDepartment(), department))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException(")"));
    }
}
