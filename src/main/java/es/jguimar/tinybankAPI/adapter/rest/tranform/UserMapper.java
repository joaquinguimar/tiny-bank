package es.jguimar.tinybankAPI.adapter.rest.tranform;

import es.jguimar.tinybankAPI.adapter.rest.dto.UserRequestDto;
import es.jguimar.tinybankAPI.adapter.rest.dto.UserResponseDto;
import es.jguimar.tinybankAPI.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserRequestDto toUserRequestDto(User source);

    UserResponseDto toUserResponseDto(User source);

}