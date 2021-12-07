package uz.jurayev.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.jurayev.academy.domain.FamilyCondition;

import java.util.Optional;

public interface FamilyConditionRepository extends JpaRepository<FamilyCondition, Long> {
    boolean existsByName(String name);

    Optional<FamilyCondition> findById(Integer id);

    void deleteById(Integer id);

}