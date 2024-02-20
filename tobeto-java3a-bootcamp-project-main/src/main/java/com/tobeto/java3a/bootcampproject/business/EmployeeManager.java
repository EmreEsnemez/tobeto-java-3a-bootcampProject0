package com.tobeto.java3a.bootcampproject.business;

import com.tobeto.java3a.bootcampproject.core.dtos.user.employee.EmployeeDto;
import com.tobeto.java3a.bootcampproject.core.dtos.user.employee.SaveEmployeeDto;
import com.tobeto.java3a.bootcampproject.dataaccess.EmployeeRepository;
import com.tobeto.java3a.bootcampproject.entities.user.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeManager {

    private EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeManager(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public List<EmployeeDto> getAll() {
        return employeeRepository.findAll().stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    public EmployeeDto getById(Long id) {
        return modelMapper.map(employeeRepository.findById(id).get(), EmployeeDto.class);
    }

    public void add(SaveEmployeeDto employeeDto) {
        employeeRepository.save(modelMapper.map(employeeDto, Employee.class));
    }

    public void update(Long id, SaveEmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employee.setId(id);

        employeeRepository.save(employee);
    }

    public void removeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
