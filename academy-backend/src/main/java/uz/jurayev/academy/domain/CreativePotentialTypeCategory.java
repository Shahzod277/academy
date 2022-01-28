package uz.jurayev.academy.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class CreativePotentialTypeCategory extends AbstractData {
    private String value; // estrada ,maqom,haykaltarosh
    @ManyToOne
    private CreativePotential creativePotential;
}
