package edu.icet.controller;

import edu.icet.dto.EmployerDTO;
import edu.icet.service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employers")
@RequiredArgsConstructor
@CrossOrigin
public class EmployerController {

    private final EmployerService employerService;

    @PostMapping("/add-employer")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployer(@RequestBody EmployerDTO employerDTO) {
        employerService.save(employerDTO);
    }

    @GetMapping("/all-employers")
    public List<EmployerDTO> getAllEmployers() {
        return employerService.getAllEmployers();
    }

    @GetMapping("/get/{id}")
    public Optional<EmployerDTO> getEmployerById(@PathVariable Integer id) {
        return employerService.getEmployerById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployer(@PathVariable Integer id, @RequestBody EmployerDTO employerDTO) {
        employerService.updateEmployer(id, employerDTO);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployer(@PathVariable Integer id) {
        employerService.deleteEmployerById(id);
    }
}
