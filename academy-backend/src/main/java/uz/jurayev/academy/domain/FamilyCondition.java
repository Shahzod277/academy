package uz.jurayev.academy.domain;

import lombok.*;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FamilyCondition extends AbstractData {

    private String name;

}