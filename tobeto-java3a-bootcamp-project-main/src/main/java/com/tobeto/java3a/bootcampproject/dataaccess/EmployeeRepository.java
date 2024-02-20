package com.tobeto.java3a.bootcampproject.dataaccess;

import com.tobeto.java3a.bootcampproject.entities.user.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
