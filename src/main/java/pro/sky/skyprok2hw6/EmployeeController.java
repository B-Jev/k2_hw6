package pro.sky.skyprok2hw6;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("lastName") String lastName,
                                @RequestParam("firstName") String firstName) {
        return employeeService.addEmployee(lastName, firstName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("lastName") String lastName,
                                   @RequestParam("firstName") String firstName) {
        return employeeService.removeEmployee(lastName, firstName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("lastName") String lastName,
                                 @RequestParam("firstName") String firstName) {
        return employeeService.findEmployee(lastName, firstName);
    }

    @GetMapping("/printall")
    public List<Employee> printAllEmployee() {
        return employeeService.printAllEmployee();
    }
}
