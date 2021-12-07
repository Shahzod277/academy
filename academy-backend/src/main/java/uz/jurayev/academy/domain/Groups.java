package uz.jurayev.academy.domain;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "groups")
public class Groups extends AbstractAuditable<User, Long> {

    private String name;
    private String courseNumber;
    @ManyToOne
    private Tutor tutor;
    @ManyToOne
    private Direction direction;

}
