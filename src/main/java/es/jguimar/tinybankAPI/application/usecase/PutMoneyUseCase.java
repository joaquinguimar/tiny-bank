package es.jguimar.tinybankAPI.application.usecase;

import es.jguimar.tinybankAPI.adapter.rest.dto.UserRequestDto;
import es.jguimar.tinybankAPI.adapter.rest.dto.UserResponseDto;
import es.jguimar.tinybankAPI.domain.model.Wallet;
import es.jguimar.tinybankAPI.infrastructure.exception.ResourceExistsException;
import es.jguimar.tinybankAPI.infrastructure.exception.ResourceNotFoundException;

public interface PutMoneyUseCase {

     Wallet putMoney(String idWallet, Double amount) throws ResourceNotFoundException;

}
