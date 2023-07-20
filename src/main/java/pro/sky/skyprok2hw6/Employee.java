package pro.sky.skyprok2hw6;

import java.util.Objects;

public class Employee {
    private String lastName;

    private String firstName;
    private long salary;

    private Integer departmentNumber;

    public Employee(String lastName, String firstName, long salary, Integer departmentNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.salary = salary;
        this.departmentNumber = departmentNumber;
    }

    public Employee(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public long getSalary() {
        return salary;
    }

    public Integer getDepartmentNumber() {
        return departmentNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && departmentNumber == employee.departmentNumber && Objects.equals(lastName, employee.lastName) && Objects.equals(firstName, employee.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, salary, departmentNumber);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", salary=" + salary +
                ", departmentNumber=" + departmentNumber +
                '}';
    }
}
