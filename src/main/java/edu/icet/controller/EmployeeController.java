package edu.icet.controller;

import edu.icet.dto.EmployeeDTO;
import edu.icet.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/add-employee")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.save(employeeDTO);
    }

    @GetMapping("/all-employee")
    public List<EmployeeDTO> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/get/{id}")
    public Optional<EmployeeDTO> getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployer(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
    }
}
