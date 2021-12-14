package uz.jurayev.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.jurayev.academy.domain.LostBreadwinner;

import java.util.Optional;

public interface LostBreadwinnerRepository extends JpaRepository<LostBreadwinner, Long> {
    boolean existsByName(String name);

    Optional<LostBreadwinner> findById(Long id);

    void deleteById(Long id);

}