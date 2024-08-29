package com.personal.emsbackend.service;

import com.personal.emsbackend.dto.EmployeeDto;
import com.personal.emsbackend.exception.ResourceNotFoundException;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId) throws ResourceNotFoundException;

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployeeDto) throws ResourceNotFoundException;

}
