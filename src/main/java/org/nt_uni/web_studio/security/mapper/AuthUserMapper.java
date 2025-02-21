package org.nt_uni.web_studio.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.nt_uni.web_studio.security.dto.AuthUserOutput;
import org.nt_uni.web_studio.security.model.AuthClient;
import org.nt_uni.web_studio.security.model.AuthUser;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthUserMapper {

    AuthUserOutput mapEntityToDto(AuthUser authUser);
    AuthUserOutput mapEntityToDto(AuthClient authUser);
}
