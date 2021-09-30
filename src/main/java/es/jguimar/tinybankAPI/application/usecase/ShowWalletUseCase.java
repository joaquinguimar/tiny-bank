package es.jguimar.tinybankAPI.application.usecase;

import es.jguimar.tinybankAPI.adapter.rest.dto.UserRequestDto;
import es.jguimar.tinybankAPI.adapter.rest.dto.UserResponseDto;
import es.jguimar.tinybankAPI.adapter.rest.dto.WalletResponseDto;
import es.jguimar.tinybankAPI.domain.model.Wallet;
import es.jguimar.tinybankAPI.infrastructure.exception.ResourceNotFoundException;

public interface ShowWalletUseCase {

     Wallet showWallet(String id) throws ResourceNotFoundException;

}
