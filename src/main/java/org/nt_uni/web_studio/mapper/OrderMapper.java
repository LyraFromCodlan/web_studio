package org.nt_uni.web_studio.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.nt_uni.web_studio.model.base.ApplicationType;
import org.nt_uni.web_studio.model.base.Order;
import org.nt_uni.web_studio.model.dto.input.OrderInput;
import org.nt_uni.web_studio.model.dto.output.OrderOutput;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    void mapDtoToEntity(OrderInput input, ApplicationType applicationType, @MappingTarget Order order);

    OrderOutput mapEntityToDto(Order order);
}
