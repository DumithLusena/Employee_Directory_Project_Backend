package edu.icet.service.impl;

import edu.icet.dto.EmployeeDTO;
import edu.icet.entity.Employee;
import edu.icet.repository.EmployeeRepository;
import edu.icet.service.EmployeeService;
import edu.icet.util.Department;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    @Override
    public void save(EmployeeDTO employerDTO) {
        if (employeeRepository.existsByEmail(employerDTO.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        try {
            Department.valueOf(employerDTO.getDepartment());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid department");
        }

        Employee employee = mapper.map(employerDTO, Employee.class);
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> entities = employeeRepository.findAll();
        List<EmployeeDTO> dtoList = new ArrayList<>();
        for (Employee e : entities) {
            dtoList.add(mapper.map(e, EmployeeDTO.class));
        }
        return dtoList;
    }

    @Override
    public Optional<EmployeeDTO> getEmployeeById(Integer id) {
        return employeeRepository.findById(id).map(employer -> mapper.map(employer, EmployeeDTO.class));
    }

    @Override
    public void updateEmployee(Integer id, EmployeeDTO employerDTO) {
        Optional<Employee> existingOpt = employeeRepository.findById(id);
        if (existingOpt.isPresent()) {
            Employee existing = existingOpt.get();
            Employee updated = mapper.map(employerDTO, Employee.class);
            updated.setId(existing.getId());
            updated.setCreatedAt(existing.getCreatedAt());
            employeeRepository.save(updated);
        } else {
            throw new RuntimeException("Employer with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Employer with ID " + id + " not found.");
        }
    }
}
