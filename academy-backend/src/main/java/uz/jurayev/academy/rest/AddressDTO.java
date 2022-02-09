package uz.jurayev.academy.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.jurayev.academy.domain.Region;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Integer districtId;
    private String details;

}
