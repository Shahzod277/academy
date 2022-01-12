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
public class Student extends AbstractData {

    private String pinfl;
    private String birthday;
    private String firstname;
    private String social_category_code;
    private String university_type_name;
    private String education_type_name;
    private String education_form_name;
    private String gender_code;
    private String payment_type_code;
    private String university_ownership_name;
    private String education_year;
    private String nationality_name;
    private String university_code;
    private String nationality_code;
    private String citizenship_name;
    private String accomodation_name;
    private String faculty_name;
    private String university_type_code;
    private String speciality_code;
    private String country_name;
    private String course;
    private String studentId;
    private String education_type_code;
    private String speciality_name;
    private String payment_type_name;
    private String address;
    private String social_category_name;
    private String serial_number;
    private String university_name;
    private String citizenship_code;
    private String university_ownership_code;
    private String soato_code;
    private String lastname;
    private String gender_name;
    private String address_current;
    private String country_code;
    private String education_form_code;
    private String fathername;
    private String district;
    private String faculty_code;
    private String region;
    private String accomodation_code;

    @ManyToOne
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