package org.nt_uni.web_studio.model.dto.input;

import lombok.Data;

@Data
public class OrderInput {
    private String orderCode;

    private String statusCode;

    private String softwareTypeCode;

    private String applicationTypeCode;

    private String description;

    private String customerEmail;

    private String phoneNumber;

    private Long priceRangeMax;

    private Long priceRangeMin;

    private Long months;

    private Boolean isSupported;

    private String managerUsername;

    private String clientUsername;
}
