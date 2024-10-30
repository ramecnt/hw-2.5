package com.example.course_work25;


import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam String department) {
        return employeeService.addEmployee(firstName, lastName, salary, department);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.deleteEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.getEmployee(firstName, lastName);
    }

    @GetMapping(path = "/list")
    public Collection<Employee> listEmployee() {
        return employeeService.getAllEmployees();
    }
}

