package uz.jurayev.academy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "direction")
@Entity
@Data
public class Direction extends AbstractAuditable<User, Long> {
    //yunalish facultet uchun
    @Column(name = "name", length = 50)
    private String name;


    @ManyToOne
    private Faculty faculty;

}