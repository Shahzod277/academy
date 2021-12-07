package uz.jurayev.academy.domain;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Table(name = "education")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Education extends AbstractData {

    private Long facultyId;

    @Column(name = "university_id")
    private Long universityId;

    @Column(name = "group_id")
    private Long groupId;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Education education = (Education) o;
        return getId() != null && Objects.equals(getId(), education.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}