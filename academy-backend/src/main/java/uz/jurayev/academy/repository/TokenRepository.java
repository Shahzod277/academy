package uz.jurayev.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.jurayev.academy.domain.ResponseToken;

public interface TokenRepository extends JpaRepository<ResponseToken, Long> {

    @Query(value = "select * from api_token order by desc 1", nativeQuery = true)
    ResponseToken getCreatedTokenDateByDesc();
}
