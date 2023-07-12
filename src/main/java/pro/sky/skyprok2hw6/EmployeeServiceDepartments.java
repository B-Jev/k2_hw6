package pro.sky.skyprok2hw6;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeServiceDepartments {
    private final EmployeeService employeeService;

    public EmployeeServiceDepartments(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee maxSalary(Integer departmentNumber) {
        List<Employee> employees = employeeService.printAllEmployee();

        return employees.stream()
                .filter(e -> e.getDepartmentNumber() == departmentNumber)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Такого сотрудника не найдено."));
    }

    public Employee minSalary(Integer departmentNumber) {
        List<Employee> employees = employeeService.printAllEmployee();

        return employees.stream()
                .filter(e -> e.getDepartmentNumber() == departmentNumber)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Такого сотрудника не найдено."));
    }

    public Map<Integer, List<Employee>> employeesByDepartment(Integer departmentNumber) {
        return streamByDepartment(departmentNumber)
                .collect(Collectors.groupingBy(Employee::getDepartmentNumber, Collectors.toList()));
    }

    private Stream<Employee> streamByDepartment(Integer departmentNumber) {
        List<Employee> employees = employeeService.printAllEmployee();
        return employees.stream()
                .filter(e -> departmentNumber == null || e.getDepartmentNumber().equals(departmentNumber));
    }

}
