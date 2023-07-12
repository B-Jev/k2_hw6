package pro.sky.skyprok2hw6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {
    private final EmployeeServiceDepartments employeeServiceDepartments;

    public DepartmentsController(EmployeeServiceDepartments employeeServiceDepartments) {
        this.employeeServiceDepartments = employeeServiceDepartments;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam Integer departmentNumber) {
        return employeeServiceDepartments.maxSalary(departmentNumber);
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam Integer departmentNumber) {
        return employeeServiceDepartments.minSalary(departmentNumber);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>>
    employeesByDepartment(@RequestParam(required = false) Integer departmentNumber) {
        return employeeServiceDepartments.employeesByDepartment(departmentNumber);
    }
}
