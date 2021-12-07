package uz.jurayev.academy.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {
    private Long facultyId;
    private Long universityId;
    private Long groupId;
}
