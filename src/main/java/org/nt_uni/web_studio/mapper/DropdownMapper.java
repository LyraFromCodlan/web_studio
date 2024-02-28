package org.nt_uni.web_studio.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.nt_uni.web_studio.model.base.ApplicationType;
import org.nt_uni.web_studio.model.dto.output.ApplicationTypeOutput;
import org.nt_uni.web_studio.model.dto.output.StatusOutput;
import org.nt_uni.web_studio.model.process.Status;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DropdownMapper {
    ApplicationTypeOutput mapEntityToDto(ApplicationType applicationType);
    StatusOutput mapEntityToDto(Status status);
}
