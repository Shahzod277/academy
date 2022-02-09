package uz.jurayev.academy.rest;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
public class TutorDto {

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

    @Column(name = "education_id")
    private Integer educationId;

    @Column(name = "gender_id")
    private Integer genderId;

    @Column(name = "nationality_id")
    private Integer nationalityId;

    @Column(name = "passport_data", length = 20)
    private String passportData;

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "attachment_id")
    private Integer attachmentId;
}
