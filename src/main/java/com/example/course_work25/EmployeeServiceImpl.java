package com.example.course_work25;

import com.example.course_work25.exceptions.EmployeeAlreadyAddedException;
import com.example.course_work25.exceptions.EmployeeNotFoundException;
import com.example.course_work25.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    int max = 10;
    List<Employee> employees = new ArrayList<>(max);


    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = null;
        try {
            if (getEmployee(firstName, lastName) != null) {
                throw new EmployeeAlreadyAddedException("Такой работник уже существует");
            }
        } catch (EmployeeNotFoundException e) {
            if (employees.size() < max) {
                employee = new Employee(firstName, lastName);
                employees.add(employee);
            } else {
                throw new EmployeeStorageIsFullException("Места нет");
            }
        }
        return employee;
    }

    public Employee deleteEmployee(String firstName, String lastName) {
        int i = 0;
        for (i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(firstName) &&
                    employees.get(i).getLastName().equals(lastName)) {
                employees.remove(i);
                break;
            }
        }
        if (i == employees.size()) {
            throw new EmployeeNotFoundException("Работник не найден");
        }
        return employees.get(i);
    }

    public Employee getEmployee(String firstName, String lastName) {
        Employee employee = null;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(firstName) &&
                    employees.get(i).getLastName().equals(lastName)) {
                employee = employees.get(i);
                break;
            }
        }
        if (employee == null) {
            throw new EmployeeNotFoundException("Работник не найден");
        }
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}
