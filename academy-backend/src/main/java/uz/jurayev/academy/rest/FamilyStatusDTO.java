package uz.jurayev.academy.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FamilyStatusDTO {
    private Boolean lowIncome;
    private Integer familyConditionId;
    private Integer invalidId;
    private Integer lostBreadwinnerId;

}
