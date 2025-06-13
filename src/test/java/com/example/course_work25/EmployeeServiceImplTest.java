package com.example.course_work25;

import com.example.course_work25.Employee.Employee;
import com.example.course_work25.Employee.EmployeeServiceImpl;
import com.example.course_work25.exceptions.EmployeeAlreadyAddedException;
import com.example.course_work25.exceptions.EmployeeNotFoundException;
import com.example.course_work25.exceptions.EmployeeStorageIsFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    void addEmployee_shouldAddEmployeeWhenNotExists() {
        Employee result = employeeService.addEmployee("John", "Doe", 50000, "1");

        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
        assertEquals(50000, result.getSalary());
        assertEquals("1", result.getDepartment());

        assertEquals(1, employeeService.getAllEmployees().size());
    }

    @Test
    void addEmployee_shouldThrowExceptionWhenEmployeeAlreadyExists() {
        employeeService.addEmployee("John", "Doe", 50000, "1");

        assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.addEmployee("John", "Doe", 50000, "1"));
    }

    @Test
    void addEmployee_shouldThrowExceptionWhenStorageIsFull() {
        for (int i = 0; i < 10; i++) {
            employeeService.addEmployee("John" + i, "Doe", 50000, "1");
        }

        assertThrows(EmployeeStorageIsFullException.class,
                () -> employeeService.addEmployee("New", "Employee", 50000, "1"));
    }

    @Test
    void deleteEmployee_shouldRemoveEmployeeWhenExists() {
        employeeService.addEmployee("John", "Doe", 50000, "1");

        Employee result = employeeService.deleteEmployee("John", "Doe");

        assertEquals("John", result.getFirstName());
        assertEquals(0, employeeService.getAllEmployees().size());
    }

    @Test
    void shouldThrowExceptionWhenEmployeeNotFound() {
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.deleteEmployee("John", "Doe"));
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.getEmployee("John", "Doe"));
    }

    @Test
    void getEmployee_shouldReturnEmployeeWhenExists() {
        employeeService.addEmployee("John", "Doe", 50000, "1");

        Employee result = employeeService.getEmployee("John", "Doe");

        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
    }


    @Test
    void getAllEmployees_shouldReturnAllEmployees() {
        employeeService.addEmployee("John", "Doe", 50000, "1");
        employeeService.addEmployee("Jane", "Smith", 60000, "HR");

        Collection<Employee> result = employeeService.getAllEmployees();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void getAllEmployeesMap_shouldReturnAllEmployeesAsMap() {
        employeeService.addEmployee("John", "Doe", 50000, "1");
        employeeService.addEmployee("Jane", "Smith", 60000, "HR");

        Map<String, Employee> result = employeeService.getAllEmployeesMap();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.containsKey("John Doe"));
        assertTrue(result.containsKey("Jane Smith"));
    }
}