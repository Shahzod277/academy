package uz.jurayev.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.jurayev.academy.domain.Address;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findById(Long id);

    void deleteById(Long id);
}