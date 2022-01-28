package uz.jurayev.academy.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table(name = "creative_potential")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor

//ijodiy salohiyat class
public class CreativePotential extends AbstractData {
    private String types; // yo'nalishlar tiplari
    @ManyToMany
    private List<Student> student;
}