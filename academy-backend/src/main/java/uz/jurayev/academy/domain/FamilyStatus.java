package uz.jurayev.academy.domain;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class FamilyStatus extends AbstractData{

    @ManyToOne
    private FamilyCondition familyConditionId;

    private Boolean lowIncome;

    @ManyToOne
    private LostBreadwinner lostBreadwinnerId;

    @ManyToOne
    private Invalid invalidId;
}