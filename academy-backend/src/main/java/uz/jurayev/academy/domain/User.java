package uz.jurayev.academy.domain;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users",
       uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
       })
@Getter
@Setter
@NoArgsConstructor
@NamedEntityGraph(name = "user_roles", attributeNodes = { @NamedAttributeNode("roles") })
public class User extends AbstractData {

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(min = 6, max = 15)
    private String password;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private String phoneNumber;

    @ManyToMany
    @JoinTable(name = "user_roles",
               joinColumns = @JoinColumn(name = "user_id"),
               inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
