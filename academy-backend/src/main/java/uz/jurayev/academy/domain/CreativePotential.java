package uz.jurayev.academy.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Table(name = "creative_potential")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor

//ijodiy salohiyat class
public class CreativePotential extends AbstractData<Integer> {

    private String types; // yo'nalishlar tiplari

    @ManyToMany
    @ToString.Exclude
    private List<Student> student;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CreativePotential that = (CreativePotential) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}