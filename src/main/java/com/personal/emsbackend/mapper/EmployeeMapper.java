package com.personal.emsbackend.mapper;

import com.personal.emsbackend.dto.EmployeeDto;
import com.personal.emsbackend.model.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getDateOfBirth(),
                employee.getGender(),
                employee.getDateOfJoining()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getPhone(),
                employeeDto.getDateOfBirth(),
                employeeDto.getGender(),
                employeeDto.getDateOfJoining()
        );
    }

}
