package org.nt_uni.web_studio.model.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.nt_uni.web_studio.model.enums.SoftwareType;
import org.nt_uni.web_studio.model.process.BusinessProcess;

import java.util.Collection;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ws_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long id;

    @Column(name = "order_code", length = 30)
    private String code;

    @Column(name = "software_type")
    private SoftwareType softwareType;

    @Column(name = "order_description", length = 1500)
    private String description;

    @Column(name = "customer_email", length = 100)
    private String customerEmail;

    @Column(name = "customer_phone_number", length = 15)
    private String phoneNumber;

    @Column(name = "customer_price_range")
    private Long priceRange;

    @Column(name = "estimated_production_time_month")
    private Long months;

    @Column(name = "is_supported")
    private Boolean isSupported;

    @Column(name = "support_expriration_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd.MM.yyyy HH:mm")
    private Date expirationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "application_type", referencedColumnName = "code", columnDefinition = "varchar(255)")
    @Fetch(FetchMode.JOIN)
    private ApplicationType applicationType;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private Collection<BusinessProcess> businessProcesses;
}
