package uz.jurayev.academy.domain;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student extends AbstractData<Long> {

    @Column(nullable = false,unique = true)
    private String pinfl;

    @Column(nullable = false)
    private String birthday;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String social_category_code;

    @Column(nullable = false)
    private String university_type_name;

    @Column(nullable = false)
    private String education_type_name;

    @Column(nullable = false)
    private String education_form_name;

    @Column(nullable = false)
    private String gender_code;

    @Column(nullable = false)
    private String payment_type_code;

    @Column(nullable = false)
    private String university_ownership_name;

    @Column(nullable = false)
    private String education_year;

    @Column(nullable = false)
    private String nationality_name;

    @Column(nullable = false)
    private String university_code;

    @Column(nullable = false)
    private String nationality_code;

    @Column(nullable = false)
    private String citizenship_name;

    @Column(nullable = false)
    private String accomodation_name;

    @Column(nullable = false)
    private String faculty_name;

    @Column(nullable = false)
    private String university_type_code;

    @Column(nullable = false)
    private String speciality_code;

    @Column(nullable = false)
    private String country_name;

    @Column(nullable = false)
    private String course;

    @Column(nullable = false)
    private String studentId;

    @Column(nullable = false)
    private String education_type_code;

    @Column(nullable = false)
    private String speciality_name;

    @Column(nullable = false)
    private String payment_type_name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String social_category_name;

    @Column(nullable = false)
    private String serial_number;

    @Column(nullable = false)
    private String university_name;

    @Column(nullable = false)
    private String citizenship_code;

    @Column(nullable = false)
    private String university_ownership_code;

    @Column(nullable = false)
    private String soato_code;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String gender_name;

    @Column(nullable = false)
    private String address_current;

    @Column(nullable = false)
    private String country_code;

    @Column(nullable = false)
    private String education_form_code;

    @Column(nullable = false)
    private String fathername;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String faculty_code;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String accomodation_code;

    @ManyToOne(optional = false)
    private Group group;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return getId() != null && Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}