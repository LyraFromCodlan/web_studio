package org.nt_uni.web_studio.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.nt_uni.web_studio.model.base.ApplicationType;
import org.nt_uni.web_studio.model.base.Order;
import org.nt_uni.web_studio.model.dto.input.OrderInput;
import org.nt_uni.web_studio.model.dto.output.OrderOutput;
import org.nt_uni.web_studio.model.process.Status;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    @Mapping(source = "applicationType", target = "order.applicationType")
    @Mapping(source = "status", target = "order.status")
    @Mapping(target = "code", ignore = true)
    void mapDtoToEntity(OrderInput input, ApplicationType applicationType, Status status, @MappingTarget Order order);

    OrderOutput mapEntityToDto(Order order);
}
