package uz.jurayev.academy.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RegionDto {
    private String name;
    private Integer countryId;
}
