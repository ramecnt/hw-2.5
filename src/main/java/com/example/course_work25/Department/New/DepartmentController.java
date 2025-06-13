package com.example.course_work25.Department.New;

import com.example.course_work25.Employee.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department/{id}/employees")
    public List<Employee> getEmployeesByDepartment(@PathVariable("id") String departmentId) {
        return departmentService.getEmployeesByDepartment(departmentId);
    }

    @GetMapping("/department/{id}/salary/sum")
    public int getSumByDepartment(@PathVariable("id") String departmentId) {
        return departmentService.getSalarySumByDepartment(departmentId);
    }

    @GetMapping("/department/{id}/salary/max")
    public int getMaxSalaryByDepartment(@PathVariable("id") String departmentId) {
        return departmentService.getMaxSalaryByDepartment(departmentId);
    }

    @GetMapping("/department/{id}/salary/min")
    public int getMinSalaryByDepartment(@PathVariable("id") String departmentId) {
        return departmentService.getMinSalaryByDepartment(departmentId);
    }

    @GetMapping("/department/employees")
    public Map<String, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return departmentService.getAllEmployeesGroupedByDepartment();
    }

}
