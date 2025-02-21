package org.nt_uni.web_studio.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.nt_uni.web_studio.model.base.Client;
import org.nt_uni.web_studio.model.base.User;
import org.nt_uni.web_studio.model.dto.input.UserInput;
import org.nt_uni.web_studio.model.dto.output.UserOutput;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User mapUserDtoToUser(UserInput input);

    Client mapUserDtoToClient(UserInput input);
    UserOutput mapEntityToDto(User user);
    UserOutput mapEntityToDto(Client user);
}
