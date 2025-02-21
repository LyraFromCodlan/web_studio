package org.nt_uni.web_studio.model.dto.output;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class OrderOutput {

    private SoftwareTypeOutput softwareType;

    private ApplicationTypeOutput applicationType;

    private StatusOutput status;

    private String code;

    private String description;

    private String customerEmail;

    private String phoneNumber;

    private Long priceRangeMax;

    private Long priceRangeMin;

    private Long months;

    private Boolean isSupported;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd.MM.yyyy HH:mm")
    private Date expirationDate;
}
