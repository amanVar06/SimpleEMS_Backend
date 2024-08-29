package com.personal.emsbackend.service.impl;

import com.personal.emsbackend.dto.EmployeeDto;
import com.personal.emsbackend.mapper.EmployeeMapper;
import com.personal.emsbackend.model.Employee;
import com.personal.emsbackend.repository.EmployeeRepository;
import com.personal.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
