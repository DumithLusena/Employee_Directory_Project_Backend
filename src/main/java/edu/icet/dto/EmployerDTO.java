package edu.icet.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployerDTO {
    private Integer id;
    private String name;
    private String email;
    private String department;
    private LocalDate createdDate;
    private LocalDate updatedDate;
}
