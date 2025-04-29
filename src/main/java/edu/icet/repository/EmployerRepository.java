package edu.icet.repository;

import edu.icet.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Integer> {
    boolean existsByEmail(String email);
}
