package edu.icet.service;

import edu.icet.dto.EmployerDTO;

import java.util.List;
import java.util.Optional;

public interface EmployerService {
    void save(EmployerDTO employerDTO);

    List<EmployerDTO> getAllEmployers();

    Optional<EmployerDTO> getEmployerById(Integer id);

    void updateEmployer(Integer id, EmployerDTO employerDTO);

    void deleteEmployerById(Integer id);
}
