package pro.sky.skyprok2hw6;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<>();

    //    public EmployeeService(){
//        employees.add(new Employee("Petrov","Aleksey",1000,1));
//        employees.add(new Employee("Petrov1","Aleksey",1100,1));
//        employees.add(new Employee("Petrov2","Aleksey",900,3));
//        employees.add(new Employee("Petrov3","Aleksey",1200,2));
//        employees.add(new Employee("Petrov4","Aleksey",800,2));
//    }

    private final int limit = 5;

    public Employee addEmployee(String lastName, String firstName) {

        controlUpperCase(lastName, firstName);
        controlAlpha(lastName, firstName);

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

    private void controlUpperCase(String lastName, String firstName) {
        String capitalizeLastName = StringUtils.capitalize(lastName);
        String capitalizeFirstName = StringUtils.capitalize(firstName);
        if (!(lastName.equals(capitalizeLastName) && (firstName.equals(capitalizeFirstName)))) {
            throw new IncorrectNameExeption("Имя и фамилия должны быть с заглавной буквы.");
        }
    }

    private void controlAlpha(String lastName, String firstName) {
        if (!(StringUtils.isAlpha(lastName) && (StringUtils.isAlpha(firstName)))) {
            throw new IncorrectNameExeption("Имя или фамилия содержат не допустимые символы.");
        }
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
