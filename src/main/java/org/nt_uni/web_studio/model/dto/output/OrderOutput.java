package org.nt_uni.web_studio.model.dto.output;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.nt_uni.web_studio.model.enums.SoftwareType;

import java.util.Date;

@Data
public class OrderOutput {

    private SoftwareType softwareType;

    private ApplicationTypeOutput applicationType;

    private String code;

    private String description;

    private String customerEmail;

    private String phoneNumber;

    private Long priceRange;

    private Long months;

    private Boolean isSupported;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd.MM.yyyy HH:mm")
    private Date expirationDate;
}
