package es.jguimar.tinybankAPI.application.usecase;

import es.jguimar.tinybankAPI.domain.model.Wallet;
import es.jguimar.tinybankAPI.infrastructure.exception.ResourceNotFoundException;

public interface PutMoneyUseCase {

     /**
      * Put money to wallet
      * @param idWallet Wallet identifier
      * @param amount real number value of amount
      * @return The wallet updated
      * @throws ResourceNotFoundException
      */
     Wallet putMoney(String idWallet, Double amount) throws ResourceNotFoundException;

}
