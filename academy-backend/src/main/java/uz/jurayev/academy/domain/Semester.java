package uz.jurayev.academy.domain;

import lombok.*;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Semester extends AbstractData<Integer> {

    private String value;
}
