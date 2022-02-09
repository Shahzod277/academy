package uz.jurayev.academy.rest;

import lombok.Data;

@Data
public class GroupDto {
    private Long id;

    private String name;

    private Long tutorId;

}
