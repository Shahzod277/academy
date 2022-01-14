package uz.jurayev.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.jurayev.academy.domain.ResponseToken;

public interface TokenRepository extends JpaRepository<ResponseToken, Long> {
}
