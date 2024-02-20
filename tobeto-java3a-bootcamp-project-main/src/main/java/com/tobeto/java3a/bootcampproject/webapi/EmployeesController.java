package com.tobeto.java3a.bootcampproject.webapi;

import com.tobeto.java3a.bootcampproject.business.EmployeeManager;
import com.tobeto.java3a.bootcampproject.core.dtos.user.employee.EmployeeDto;
import com.tobeto.java3a.bootcampproject.core.dtos.user.employee.SaveEmployeeDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    private EmployeeManager employeeManager;

    public EmployeesController(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @GetMapping("/")
    public List<EmployeeDto> getAll() {
        return employeeManager.getAll();
    }

    @GetMapping("/{id}")
    public EmployeeDto
    getById(@PathVariable Long id) {
        return employeeManager.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody SaveEmployeeDto employee) {
        employeeManager.add(employee);
    }

    @PostMapping("/edit")
    public void edit(@PathVariable Long id, @RequestBody SaveEmployeeDto employee) {
        employeeManager.update(id, employee);
    }

    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        employeeManager.removeById(id);
    }
}
