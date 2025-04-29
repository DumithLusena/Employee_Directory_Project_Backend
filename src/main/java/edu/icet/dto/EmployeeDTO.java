package edu.icet.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private String department;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
