package uz.jurayev.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.jurayev.academy.domain.University;

public interface UniversityRepository extends JpaRepository<University, Integer> {
    boolean existsByName(String name);
}