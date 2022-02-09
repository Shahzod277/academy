package uz.jurayev.academy.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MapKey;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Table(name = "tutor")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Tutor extends AbstractData<Integer> {

    @Column(name = "surname", length = 30)
    private String surname;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "lastname", length = 30)
    private String lastname;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "temporal_address_id")
    private Integer temporalAddressId;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @Column(name = "gender_id")
    private Integer genderId;

    @Column(name = "nationality_id")
    private Integer nationalityId;

    @Column(name = "passport_data", length = 20)
    private String passportData;

    @Column(name = "experience") //tajriba
    private Integer experience;

    @Column(name = "attachment_id")
    private Integer attachmentId;

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
        Tutor tutor = (Tutor) o;
        return getId() != null && Objects.equals(getId(), tutor.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}