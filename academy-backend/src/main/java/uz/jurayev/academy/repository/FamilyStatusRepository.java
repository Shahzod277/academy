package uz.jurayev.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.jurayev.academy.domain.FamilyStatus;

import java.util.Optional;

public interface FamilyStatusRepository extends JpaRepository<FamilyStatus, Long> {
    Optional<FamilyStatus> findById(Integer id);

    void deleteById(Integer id);

}