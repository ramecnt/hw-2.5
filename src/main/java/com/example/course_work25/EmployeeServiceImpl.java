package com.example.course_work25;

import com.example.course_work25.exceptions.EmployeeAlreadyAddedException;
import com.example.course_work25.exceptions.EmployeeNotFoundException;
import com.example.course_work25.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    int max = 10;
    Map<String, Employee> employees = new HashMap<>();


    public Employee addEmployee(String firstName, String lastName, int salary, String department) {
        Employee employee = null;
        try {
            if (getEmployee(firstName, lastName) != null) {
                throw new EmployeeAlreadyAddedException("Такой работник уже существует");
            }
        } catch (EmployeeNotFoundException e) {
            if (employees.size() < max) {
                employee = new Employee(firstName, lastName, salary, department);
                employees.put(firstName + " " + lastName, employee);
            } else {
                throw new EmployeeStorageIsFullException("Места нет");
            }
        }
        return employee;
    }

    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = employees.get(firstName + " " + lastName);
        if (employee == null) {
            throw new EmployeeNotFoundException("Работник не найден");
        }
        employees.remove(firstName + " " + lastName);
        return employee;
    }

    public Employee getEmployee(String firstName, String lastName) {
        Employee employee = employees.get(firstName + " " + lastName);
        if (employee == null) {
            throw new EmployeeNotFoundException("Работник не найден");
        }
        return employee;
    }

    public Collection<Employee> getAllEmployees() {
        return employees.values();
    }
}
