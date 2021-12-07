package uz.jurayev.academy.domain;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Region extends AbstractData{

    private String regionName;

    @ManyToOne
    private Country country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Region region = (Region) o;
        return getId() != null && Objects.equals(getId(), region.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}