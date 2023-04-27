package com.itElites.employeeFlux.controllers;

import com.itElites.employeeFlux.models.Employee;
import com.itElites.employeeFlux.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/employees")
public class Employeecontroller {

    @Autowired
    private RestTemplate restTemplate;
   @Autowired
   private EmployeeRepository repo;
    @PostMapping("/createData")
    public Mono<Employee> addData(@RequestBody Employee employee){
        return repo.save(employee);
    }
    @PutMapping("/update/{empId}")
    public Mono<Employee> updateData(@PathVariable String empId, @RequestBody Employee employee){
        Mono<Employee> existingData = repo.findById(empId);
        employee.setName(employee.getName());
        employee.setAddress(employee.getAddress());
        employee.setDepartment(employee.getDepartment());
        return repo.save(employee);
    }

    @GetMapping("/fetchEmployee/{empId}")
    public Mono<Employee> fetchEmployee(@PathVariable String empId){
        Mono<Employee> employee = repo.findById(empId);

        return (employee);
    }
    @GetMapping("/filterEmployeesByDep/{department}")
    public Mono<List<Employee>> employeesByDepartment(@PathVariable String department) {
        return repo.findAll().filter(x -> x.getDepartment().contains(department)).collect(Collectors.toList());
    }
    @GetMapping("/findAll")

        public Flux<Employee> employees(){
            return repo.findAll();

    }
}




