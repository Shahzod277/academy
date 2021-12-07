package uz.jurayev.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.jurayev.academy.domain.Groups;

public interface GroupRepository extends JpaRepository<Groups, Long> {
}
