package es.jguimar.tinybankAPI.application.usecase;

import es.jguimar.tinybankAPI.domain.model.Wallet;
import es.jguimar.tinybankAPI.infrastructure.exception.ResourceNotFoundException;

public interface ShowWalletUseCase {

     /**
      * Show wallet data
      * @param id Wallet identifier
      * @return The wallet finded
      * @throws ResourceNotFoundException
      */
     Wallet showWallet(String id) throws ResourceNotFoundException;

}
