package org.nt_uni.web_studio.model.dto.input;

import lombok.Data;
import org.nt_uni.web_studio.model.enums.SoftwareType;

@Data
public class OrderInput {
    private String orderCode;

    private String statusCode;

    private SoftwareType softwareType;

    private String applicationTypeCode;

    private String description;

    private String customerEmail;

    private String phoneNumber;

    private Long priceRange;

    private Long months;

    private Boolean isSupported;
}
