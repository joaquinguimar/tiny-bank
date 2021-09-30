package es.jguimar.tinybankAPI.application.usecase;

import es.jguimar.tinybankAPI.adapter.rest.dto.UserResponseDto;
import es.jguimar.tinybankAPI.adapter.rest.dto.WalletRequestDto;
import es.jguimar.tinybankAPI.adapter.rest.dto.WalletResponseDto;
import es.jguimar.tinybankAPI.domain.model.Wallet;
import es.jguimar.tinybankAPI.infrastructure.exception.ResourceExistsException;

import java.util.List;

public interface CreateWalletUseCase {

    Wallet create(List<String> userId);
}
