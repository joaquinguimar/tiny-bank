package es.jguimar.tinybankAPI.adapter.rest.tranform;

import es.jguimar.tinybankAPI.adapter.rest.dto.UserResponseDto;
import es.jguimar.tinybankAPI.adapter.rest.dto.WalletResponseDto;
import es.jguimar.tinybankAPI.domain.model.User;
import es.jguimar.tinybankAPI.domain.model.Wallet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WalletMapper {

    WalletResponseDto toWalletResponseDto(Wallet source);

    UserResponseDto toUserResponseDto(User source);

}