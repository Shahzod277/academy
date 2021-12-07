package uz.jurayev.academy.rest;

import lombok.Data;


@Data
public class RelativeDto {
    private String name;

    private String surname;

    private String lastname;

    private Long addressId;

    private String phoneNumber;

    private Long invalidId;

    private Long relativesTypeId;

    private Long benefitId;
}
