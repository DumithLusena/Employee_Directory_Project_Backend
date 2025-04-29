package edu.icet.service.impl;

import edu.icet.dto.EmployerDTO;
import edu.icet.entity.Employer;
import edu.icet.repository.EmployerRepository;
import edu.icet.service.EmployerService;
import edu.icet.util.Department;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployerServiceImpl implements EmployerService {

    private final EmployerRepository employerRepository;
    private final ModelMapper mapper;

    @Override
    public void save(EmployerDTO employerDTO) {
        if (employerRepository.existsByEmail(employerDTO.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        try {
            Department.valueOf(employerDTO.getDepartment());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid department");
        }

        Employer employee = mapper.map(employerDTO, Employer.class);
        employerRepository.save(employee);
    }

    @Override
    public List<EmployerDTO> getAllEmployers() {
        List<Employer> entities = employerRepository.findAll();
        List<EmployerDTO> dtoList = new ArrayList<>();
        for (Employer e : entities) {
            dtoList.add(mapper.map(e, EmployerDTO.class));
        }
        return dtoList;
    }

    @Override
    public Optional<EmployerDTO> getEmployerById(Integer id) {
        return employerRepository.findById(id).map(employer -> mapper.map(employer, EmployerDTO.class));
    }

    @Override
    public void updateEmployer(Integer id, EmployerDTO employerDTO) {
        Optional<Employer> existingOpt = employerRepository.findById(id);
        if (existingOpt.isPresent()) {
            Employer existing = existingOpt.get();
            Employer updated = mapper.map(employerDTO, Employer.class);
            updated.setId(existing.getId());
            updated.setCreatedAt(existing.getCreatedAt());
            employerRepository.save(updated);
        } else {
            throw new RuntimeException("Employer with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteEmployerById(Integer id) {
        if (employerRepository.existsById(id)) {
            employerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Employer with ID " + id + " not found.");
        }
    }
}
