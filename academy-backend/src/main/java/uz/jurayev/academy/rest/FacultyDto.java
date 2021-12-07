package uz.jurayev.academy.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacultyDto {
    private String name;
    private Long universityId;
}
