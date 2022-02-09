package uz.jurayev.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.jurayev.academy.domain.District;

import java.util.Optional;

public interface DistrictRepository extends JpaRepository<District, Integer> {

    boolean existsByDistrictName(String districtName);
}