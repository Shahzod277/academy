package uz.jurayev.academy.domain;

import lombok.*;

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
public class Group extends AbstractData {

    private String groupId;

    @ManyToOne(optional = false)
    private Tutor tutor;
}
