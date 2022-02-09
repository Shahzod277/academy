package uz.jurayev.academy.domain;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.AbstractAuditable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Table(name = "attachment_content")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class AttachmentContent extends AbstractData<Integer> {

    @Column(name = "value")
    private byte[] value;

    @Column(name = "attachment_id")
    private Integer attachmentId;

    public Integer getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Integer attachmentId) {
        this.attachmentId = attachmentId;
    }

    public byte[] getValue() {
        return value;
    }

    public void setValue(byte[] value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AttachmentContent that = (AttachmentContent) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}