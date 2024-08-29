package com.personal.emsbackend.service.impl;

import com.personal.emsbackend.dto.EmployeeDto;
import com.personal.emsbackend.exception.ResourceNotFoundException;
import com.personal.emsbackend.mapper.EmployeeMapper;
import com.personal.emsbackend.model.Employee;
import com.personal.emsbackend.repository.EmployeeRepository;
import com.personal.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) throws ResourceNotFoundException {

        Employee employee = employeeRepository
                .findById(employeeId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee does not exists with given id: " + employeeId)
                );

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployeeDto) throws ResourceNotFoundException {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exists with given id: " + employeeId)
        );

        employee.setFirstName(updatedEmployeeDto.getFirstName());
        employee.setLastName(updatedEmployeeDto.getLastName());
        employee.setEmail(updatedEmployeeDto.getEmail());
        employee.setDateOfBirth(updatedEmployeeDto.getDateOfBirth());
        employee.setPhone(updatedEmployeeDto.getPhone());
        employee.setGender(updatedEmployeeDto.getGender());
        employee.setDateOfJoining(updatedEmployeeDto.getDateOfJoining());

        Employee updatedEmployeeObject = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObject);
    }
}
