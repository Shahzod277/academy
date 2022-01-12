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

    private Long studentId;
    private String pinfl;
    private String serialNumber;
    private String firstname;
    private String lastname;
    private String fathername;
    private String birthday;
    private Integer genderCode;
    private String genderName;
    private Integer nationalityCode;
    private String nationalityName;
    private Integer citizenshipCode;
    private String citizenshipName;
    private Integer educationTypeCode;
    private String educationTypeName;
    private Integer educationFormCode;
    private String educationFormName;
    private Integer paymentTypeCode;
    private String paymentTypeName;
    private Integer universityCode;
    private String universityName;
    private Integer universityOwnershipCode;
    private String universityOwnershipName;
    private Integer universityTypeCode;
    private String universityTypeName;
    private String facultyCode;
    private String facultyName;
    private String specialityCode;
    private String specialityName;
    private String course;
    private String countryCode;
    private String countryName;
    private String soatoCode;
    private String region;
    private String district;
    private String address;
    private String addressCurrent;
    private String accomodationCode;
    private String accomodationName;
    private String socialCategoryCode;
    private String socialCategoryName;
    private String educationYear;

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