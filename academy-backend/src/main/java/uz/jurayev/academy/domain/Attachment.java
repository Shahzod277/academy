package uz.jurayev.academy.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Table(name = "attachment")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Attachment extends AbstractData {

    @Column(name = "name", length = 250)
    private String name;
    @Column(name = "size")
    private Long size;

    private String contentType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Attachment that = (Attachment) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}