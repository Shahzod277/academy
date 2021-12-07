package uz.jurayev.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.jurayev.academy.domain.AttachmentContent;

import java.util.Optional;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Long> {
    @Query(value = "select * from attachment_content where attachment_id =:id", nativeQuery = true)
    Optional<AttachmentContent> getAttachmentContent(Long id);

}