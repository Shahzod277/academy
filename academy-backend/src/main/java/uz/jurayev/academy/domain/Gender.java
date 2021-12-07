package uz.jurayev.academy.domain;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Table(name = "gender")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Gender extends AbstractData {

    @Column(name = "name", length = 30)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Gender gender = (Gender) o;
        return getId() != null && Objects.equals(getId(), gender.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}