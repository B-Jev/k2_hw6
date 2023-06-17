package pro.sky.skyprok2hw6;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<>();
    private final int limit = 3;

    public Employee addEmployee(String lastName, String firstName) {
        if (lastName.isBlank() || firstName.isBlank()) {
            throw new RuntimeException();
        }
        if (employees.size() >= limit) {
            throw new EmployeeStoragelsFullException("Список сотрудников привышен");
        }
        Employee employeeNew = new Employee(lastName, firstName);

        if (employees.contains(employeeNew)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже зарегестрирован");
        }
        employees.add(employeeNew);
        return employeeNew;
    }

    public Employee removeEmployee(String lastName, String firstName) {
        Employee employeeRemove = new Employee(lastName, firstName);
        if (employees.contains(employeeRemove)) {
            employees.remove(employeeRemove);
            return employeeRemove;
        } else {
            throw new EmployeeNotFoundException("Такого сотрудника нет.");
        }
    }

    public Employee findEmployee(String lastName, String firstName) {
        Employee employeeFind = new Employee(lastName, firstName);

        if (employees.contains(employeeFind)) {
            return employees.get(employees.indexOf(employeeFind));
        } else {
            throw new EmployeeNotFoundException("Такого сотрудника в списке нет.");
        }
    }

    public List<Employee> printAllEmployee() {
        return employees;
    }
}
