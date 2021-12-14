package uz.jurayev.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.jurayev.academy.domain.Invalid;

import java.util.Optional;

public interface InvalidRepository extends JpaRepository<Invalid,Long> {

    boolean existsByName(String name);

    Optional<Invalid> findById(Long id);

    void deleteById(Long id);

}
