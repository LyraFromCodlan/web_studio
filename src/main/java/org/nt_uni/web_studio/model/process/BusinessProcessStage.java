package org.nt_uni.web_studio.model.process;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_business_process_stage")
public class BusinessProcessStage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "begin_ts")
    private Date beginTs;

    @Column(name = "end_ts")
    private Date endTs;

    @Column(name = "priority_code")
    private Long priority;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_code")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "order_business_process_id")
    private BusinessProcess businessProcess;

}
