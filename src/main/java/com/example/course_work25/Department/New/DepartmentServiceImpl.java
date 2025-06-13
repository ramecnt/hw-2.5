package com.example.course_work25.Department.New;

import com.example.course_work25.Employee.Employee;
import com.example.course_work25.Employee.EmployeeService;
import com.example.course_work25.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String departmentId) {
        List<Employee> employees = employeeService.getAllEmployeesMap().values().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .collect(Collectors.toList());
        if (employees.isEmpty()) {
            throw new EmployeeNotFoundException("В департаменте " + departmentId + " нет сотрудников(");
        }
        return employees;
    }

    @Override
    public int getSalarySumByDepartment(String departmentId) {
        List<Employee> employees = getEmployeesByDepartment(departmentId);
        return employees.stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    @Override
    public int getMaxSalaryByDepartment(String departmentId) {
        List<Employee> employees = getEmployeesByDepartment(departmentId);
        return employees.stream()
                .mapToInt(Employee::getSalary)
                .max().orElseThrow(() -> new EmployeeNotFoundException("В департаменте " + departmentId + " нет сотрудников("));
    }

    @Override
    public int getMinSalaryByDepartment(String departmentId) {
        List<Employee> employees = getEmployeesByDepartment(departmentId);
        return employees.stream()
                .mapToInt(Employee::getSalary)
                .min().orElseThrow(() -> new EmployeeNotFoundException("В департаменте " + departmentId + " нет сотрудников("));
    }

    @Override
    public Map<String, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return employeeService.getAllEmployeesMap().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
