package uz.jurayev.academy.domain;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Table(name = "benefit")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Benefit extends AbstractData {

    @Column(name = "name", length = 30)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Benefit benefit = (Benefit) o;
        return getId() != null && Objects.equals(getId(), benefit.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}