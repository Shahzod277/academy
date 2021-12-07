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
public class District extends AbstractData{

    private String districtName;

    @ManyToOne
    private Region region;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        District district = (District) o;
        return getId() != null && Objects.equals(getId(), district.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}