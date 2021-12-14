package uz.jurayev.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.jurayev.academy.domain.Address;
import uz.jurayev.academy.domain.Country;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    boolean existsByCountryName(String countryName);

    Optional<Country> findById(Long id);

    void deleteById(Long id);
}