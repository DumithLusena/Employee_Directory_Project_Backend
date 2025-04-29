package edu.icet.dto;


import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EmployerDTO {
    private Long id;
    private String name;
    private String email;
    private String department;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
