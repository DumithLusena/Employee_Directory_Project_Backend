package edu.icet.entity;

import edu.icet.util.Department;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "employers")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private Department department;

    private LocalDate createdDate;
    private LocalDate updatedDate;
}
