package uz.jurayev.academy.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FamilyStatusDTO {
    private Boolean lowIncome;
    private Long familyConditionId;
    private Long invalidId;
    private Long lostBreadwinnerId;

}
