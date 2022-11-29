package com.robosoft.SpringBootSpringJPA.repository;

import com.robosoft.SpringBootSpringJPA.modal.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
    //ArrayList<Employee> findAllEmployee();
}