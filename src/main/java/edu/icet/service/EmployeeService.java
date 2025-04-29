package edu.icet.service;

import edu.icet.dto.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    void save(EmployeeDTO employerDTO);

    List<EmployeeDTO> getAllEmployee();

    Optional<EmployeeDTO> getEmployeeById(Integer id);

    void updateEmployee(Integer id, EmployeeDTO employerDTO);

    void deleteEmployeeById(Integer id);
}
