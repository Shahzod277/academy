package uz.jurayev.academy.rest;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
public class StudentDto {

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "surname", length = 30)
    private String surname;

    @Column(name = "lastname", length = 30)
    private String lastname;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "temporal_address_id")
    private Long temporalAddressId;

    @Column(name = "family_status_id")
    private Long familyStatusId;

    @Column(name = "phone_number", length = 15, unique = true)
    private String phoneNumber;

    @Column(name = "education_id")
    private Long educationId;

    @Column(name = "gender_id")
    private Long genderId;

    @Column(name = "nationality_id")
    private Long nationalityId;

    @Column(name = "telegram_phone_number", length = 20)
    private String telegramPhoneNumber;

    @Column(name = "relatives_id")
    private Long relativesId;

    @Column(name = "creative_potential_id")
    private Long creativePotentialId;

    @Column(name = "rating_status_id")
    private Long ratingStatusId;

    private String passportData;

    private Long groupId;
}

