package es.jguimar.tinybankAPI.application.usecase;

import es.jguimar.tinybankAPI.domain.model.Wallet;
import es.jguimar.tinybankAPI.infrastructure.exception.ResourceNotFoundException;

public interface TransferMoneyUseCase {

     /**
      * Make a money transfer between
      * @param idAccountSource Wallet identifier from do transfer
      * @param idAccountTarget Wallet identifier to do transfer
      * @param amount real number value of amount
      * @return The target wallet updated
      * @throws ResourceNotFoundException
      */
     Wallet transferMoney(String idAccountSource, String idAccountTarget, Double amount) throws ResourceNotFoundException;

}
