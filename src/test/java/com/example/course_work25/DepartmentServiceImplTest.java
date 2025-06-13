package com.example.course_work25;

import com.example.course_work25.Employee.Employee;
import com.example.course_work25.Department.New.DepartmentServiceImpl;
import com.example.course_work25.Employee.EmployeeService;
import com.example.course_work25.exceptions.EmployeeNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetEmployeesByDepartment() {
        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put("John Doe", new Employee("John", "Doe", 5000, "1"));
        employeeMap.put("Jane Smith", new Employee("Jane", "Smith", 7000, "1"));

        when(employeeService.getAllEmployeesMap()).thenReturn(employeeMap);

        List<Employee> result = departmentService.getEmployeesByDepartment("1");

        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFirstName());
        assertEquals("Jane", result.get(1).getFirstName());
    }

    @Test
    public void testGetEmployeesByDepartmentThrowsException() {
        when(employeeService.getAllEmployeesMap()).thenReturn(new HashMap<>());

        assertThrows(EmployeeNotFoundException.class, () -> {
            departmentService.getEmployeesByDepartment("999");
        });
    }

    @Test
    public void testGetSalarySumByDepartment() {
        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put("John Doe", new Employee("John", "Doe", 5000, "1"));
        employeeMap.put("Jane Smith", new Employee("Jane", "Smith", 7000, "1"));

        when(employeeService.getAllEmployeesMap()).thenReturn(employeeMap);

        int sum = departmentService.getSalarySumByDepartment("1");

        assertEquals(12000, sum);
    }

    @Test
    public void testGetMaxSalaryByDepartment() {
        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put("John Doe", new Employee("John", "Doe", 5000, "1"));
        employeeMap.put("Jane Smith", new Employee("Jane", "Smith", 7000, "1"));

        when(employeeService.getAllEmployeesMap()).thenReturn(employeeMap);

        int maxSalary = departmentService.getMaxSalaryByDepartment("1");

        assertEquals(7000, maxSalary);
    }

    @Test
    public void testGetAllEmployeesGroupedByDepartment() {
        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put("John Doe", new Employee("John", "Doe", 5000, "1"));
        employeeMap.put("Jane Smith", new Employee("Jane", "Smith", 7000, "1"));
        employeeMap.put("Alice Brown", new Employee("Alice", "Brown", 6000, "2"));

        when(employeeService.getAllEmployeesMap()).thenReturn(employeeMap);

        Map<String, List<Employee>> result = departmentService.getAllEmployeesGroupedByDepartment();

        assertEquals(2, result.size());
        assertEquals(2, result.get("1").size());
        assertEquals(1, result.get("2").size());
    }
}