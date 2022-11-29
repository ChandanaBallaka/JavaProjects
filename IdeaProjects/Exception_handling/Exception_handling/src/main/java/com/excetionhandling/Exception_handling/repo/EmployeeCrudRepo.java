package com.excetionhandling.Exception_handling.repo;

import com.excetionhandling.Exception_handling.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeCrudRepo extends JpaRepository<Employee, Long>
{

}
