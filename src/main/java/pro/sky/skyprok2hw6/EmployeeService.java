package pro.sky.skyprok2hw6;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    Map<String, Employee> employeesFullName = new HashMap<>();
    private final int limit = 3;

    private String getFullName(Employee employee) {
        return employee.getLastName() + employee.getFirstName();
    }

    public Employee addEmployee(String lastName, String firstName) {
        if (lastName.isBlank() || firstName.isBlank()) {
            throw new RuntimeException();
        }
        if (employeesFullName.size() >= limit) {
            throw new EmployeeStoragelsFullException("Список сотрудников привышен");
        }
        Employee employeeNew = new Employee(lastName, firstName);
        String fullName = getFullName(employeeNew);


        if (employeesFullName.containsKey(fullName)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже зарегестрирован");
        }
        employeesFullName.put(fullName, employeeNew);
        return employeeNew;
    }

    public Employee removeEmployee(String lastName, String firstName) {
        Employee employeeRemove = new Employee(lastName, firstName);
        String fullName = getFullName(employeeRemove);

        if (employeesFullName.containsKey(fullName)) {
            employeesFullName.remove(fullName, employeeRemove);
            return employeeRemove;
        } else {
            throw new EmployeeNotFoundException("Такого сотрудника нет.");
        }
    }

    public Employee findEmployee(String lastName, String firstName) {
        Employee employeeFind = new Employee(lastName, firstName);
        String fullName = getFullName(employeeFind);

        if (employeesFullName.containsKey(fullName)) {
            return employeesFullName.get(fullName);
        } else {
            throw new EmployeeNotFoundException("Такого сотрудника в списке нет.");
        }
    }

    public Collection<Employee> printAllEmployee() {
        return employeesFullName.values();
    }
}
