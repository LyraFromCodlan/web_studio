package org.nt_uni.web_studio.model.dto.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.Data;
import org.nt_uni.web_studio.model.enums.SoftwareType;

import java.util.Date;

@Data
public class OrderInput {

    private SoftwareType softwareType;

    private String applicationTypeCode;

    private String description;

    private String customerEmail;

    private String phoneNumber;

    private Long priceRange;

    private Long months;

    private Boolean isSupported;
}
