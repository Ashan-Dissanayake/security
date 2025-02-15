package lk.ashan.security.controller;

import lk.ashan.security.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @GetMapping(produces = "application/json")
    public List<Employee> getAll(){

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Minuri", "Female"));
        employees.add(new Employee(2, "Ashan", "Male"));
        employees.add(new Employee(3, "Pathum", "Male"));

        return  employees;

    }

}
