package uz.jurayev.academy.domain;

import lombok.*;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LostBreadwinner extends AbstractData {

    private String name;

}