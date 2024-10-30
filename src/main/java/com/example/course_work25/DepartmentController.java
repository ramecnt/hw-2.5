package com.example.course_work25;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee getMaxSalary(@RequestParam String department) {
        return departmentService.getMaxSalary(department);
    }

    @GetMapping(path = "/min-salary")
    public Employee getMinSalary(@RequestParam String department) {
        return departmentService.getMinSalary(department);
    }

    @GetMapping(path = "/all")
    public Map<String, List<Employee>> findEmployeeByDepartment(@RequestParam(defaultValue = "all") String department) {
        if (department.equals("all")) {
            return departmentService.getAllEmployeesByDepartments();
        } else {
            return departmentService.getEmployeesByDepartment(department);
        }
    }
}
