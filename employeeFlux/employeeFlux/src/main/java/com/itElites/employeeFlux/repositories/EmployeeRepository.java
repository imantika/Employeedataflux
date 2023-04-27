package com.itElites.employeeFlux.repositories;

import com.itElites.employeeFlux.models.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {
}
