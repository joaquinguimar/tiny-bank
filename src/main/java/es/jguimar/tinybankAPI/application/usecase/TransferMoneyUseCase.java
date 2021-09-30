package es.jguimar.tinybankAPI.application.usecase;

import es.jguimar.tinybankAPI.adapter.rest.dto.WalletResponseDto;
import es.jguimar.tinybankAPI.domain.model.Wallet;
import es.jguimar.tinybankAPI.infrastructure.exception.ResourceNotFoundException;

public interface TransferMoneyUseCase {

     Wallet transferMoney(String idAccountSource, String idAccountTarget, Double amount) throws ResourceNotFoundException;

}
