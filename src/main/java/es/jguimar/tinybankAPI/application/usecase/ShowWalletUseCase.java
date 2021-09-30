package es.jguimar.tinybankAPI.application.usecase;

import es.jguimar.tinybankAPI.domain.model.Wallet;
import es.jguimar.tinybankAPI.infrastructure.exception.ResourceNotFoundException;

public interface ShowWalletUseCase {

     Wallet showWallet(String id) throws ResourceNotFoundException;

}
