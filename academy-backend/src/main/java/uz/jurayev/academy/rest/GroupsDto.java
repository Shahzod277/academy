package uz.jurayev.academy.rest;

import lombok.Data;

@Data
public class GroupsDto {
    private String name;
    private String courseNumber;
    private Long tutorId;
    private Long directionId;
}
