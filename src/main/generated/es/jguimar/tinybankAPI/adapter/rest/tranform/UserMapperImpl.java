package es.jguimar.tinybankAPI.adapter.rest.tranform;

import es.jguimar.tinybankAPI.adapter.rest.dto.UserRequestDto;
import es.jguimar.tinybankAPI.adapter.rest.dto.UserResponseDto;
import es.jguimar.tinybankAPI.domain.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-30T15:18:38+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserRequestDto toUserRequestDto(User source) {
        if ( source == null ) {
            return null;
        }

        UserRequestDto userRequestDto = new UserRequestDto();

        userRequestDto.setName( source.getName() );
        userRequestDto.setPassword( source.getPassword() );

        return userRequestDto;
    }

    @Override
    public UserResponseDto toUserResponseDto(User source) {
        if ( source == null ) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId( source.getId() );
        userResponseDto.setName( source.getName() );

        return userResponseDto;
    }
}
