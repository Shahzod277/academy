package uz.jurayev.academy.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Table(name = "faculty")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Faculty extends AbstractData {

    @Column(name = "name", length = 50)
    private String name;
    private Long universityId;

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
        Faculty faculty = (Faculty) o;
        return getId() != null && Objects.equals(getId(), faculty.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}