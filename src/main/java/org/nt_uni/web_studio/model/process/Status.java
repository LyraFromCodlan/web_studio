package org.nt_uni.web_studio.model.process;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_status")
public class Status {
    @Id
    @Column(name = "code", length = 15, nullable = false, unique = true)
    private String code;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "status")
    private Collection<BusinessProcessStage> businessProcessStages;
}
