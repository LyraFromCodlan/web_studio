package org.nt_uni.web_studio.security.model;

import lombok.*;

import jakarta.persistence.*;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "authority", schema = "security")
public class Authority {

    @Id
    @Column(name = "authority", length = 15)
    private String authority;

    @Column(name = "name", length = 30)
    private String name;

    @ManyToMany(mappedBy = "authorities")
    private Set<AuthUser> authUsers;

    @ManyToMany(mappedBy = "authorities")
    private Set<AuthClient> authClients;
}