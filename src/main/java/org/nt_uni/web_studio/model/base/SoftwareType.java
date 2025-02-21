package org.nt_uni.web_studio.model.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "software_type")
public class SoftwareType {
    @Id
    @Column(name = "code", length = 10)
    private String code;

    @Column(name = "name", length = 30, nullable = false)
    private String name;
}

