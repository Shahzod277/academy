package uz.jurayev.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.jurayev.academy.domain.Region;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Long> {
    boolean existsByRegionName(String name);

    Optional<Region> findById(Integer id);

    void deleteById(Integer id);
}