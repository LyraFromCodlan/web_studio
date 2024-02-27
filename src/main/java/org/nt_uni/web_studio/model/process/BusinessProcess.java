package org.nt_uni.web_studio.model.process;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.nt_uni.web_studio.model.base.Order;

import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_business_process")
public class BusinessProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "created_ts")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd.MM.yyyy HH:mm")
    private Date createdTs;

    @Column(name = "finished_ts")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd.MM.yyyy HH:mm")
    private Date finishedTs;

    @OrderBy("priority ASC")
    @OneToMany(mappedBy = "businessProcess")
    private Collection<BusinessProcessStage> stages;

    @Transient
    private Status status;
}
