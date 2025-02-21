package org.nt_uni.web_studio.model.base;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user", schema = "public")
public class User {

    @Id
    @Column(name = "username", length = 9)
    private String username;

    @Column(name = "firstname", length = 15)
    private String firstname;

    @Column(name = "lastname", length = 15)
    private String lastname;

    @Column(name = "surname", length = 15)
    private String surname;

    @Column(name = "email", length = 40)
    private String email;

    @Column(name = "phone_number", length = 12)
    private String phoneNumber;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;
}