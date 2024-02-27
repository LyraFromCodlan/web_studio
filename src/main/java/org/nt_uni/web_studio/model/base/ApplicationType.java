package org.nt_uni.web_studio.model.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_application_type")
public class ApplicationType {
    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;
}
