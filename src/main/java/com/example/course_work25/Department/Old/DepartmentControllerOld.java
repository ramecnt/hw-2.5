package com.example.course_work25.Department.Old;

import com.example.course_work25.Employee.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentControllerOld {
    private final DepartmentServiceOld departmentServiceOld;

    public DepartmentControllerOld(DepartmentServiceOld departmentServiceOld) {
        this.departmentServiceOld = departmentServiceOld;
    }

    @GetMapping(path = "/max-salary")
    public Employee getMaxSalary(@RequestParam String department) {
        return departmentServiceOld.getMaxSalary(department);
    }

    @GetMapping(path = "/min-salary")
    public Employee getMinSalary(@RequestParam String department) {
        return departmentServiceOld.getMinSalary(department);
    }

    @GetMapping(path = "/all")
    public Map<String, List<Employee>> findEmployeeByDepartment(@RequestParam(defaultValue = "all") String department) {
        if (department.equals("all")) {
            return departmentServiceOld.getAllEmployeesByDepartments();
        } else {
            return departmentServiceOld.getEmployeesByDepartment(department);
        }
    }
}
