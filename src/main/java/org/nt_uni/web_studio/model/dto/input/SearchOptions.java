package org.nt_uni.web_studio.model.dto.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Collection;
import java.util.Date;

@Data
public class SearchOptions {
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd.MM.yyyy")
    private Date beginDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd.MM.yyyy")
    private Date endDate;
    private Collection<String> softwareTypes;
    private Collection<String> applicationTypes;
    private Boolean isSupported;
    private Boolean isFinished;
    private Long supportLongevity;
    private Long priceHighBar;
    private Long priceLowBar;
    private Long developmentTimeMonths;
}
