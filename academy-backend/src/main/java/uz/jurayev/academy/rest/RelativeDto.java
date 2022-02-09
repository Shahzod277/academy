package uz.jurayev.academy.rest;

import lombok.Data;


@Data
public class RelativeDto {
    private String name;

    private String surname;

    private String lastname;

    private Integer addressId;

    private String phoneNumber;

    private Integer invalidId;

    private Integer relativesTypeId;

    private Integer benefitId;
}
