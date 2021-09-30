package es.jguimar.tinybankAPI.application.usecase;

import es.jguimar.tinybankAPI.domain.model.Wallet;
import es.jguimar.tinybankAPI.infrastructure.exception.ResourceNotFoundException;

public interface PutMoneyUseCase {

     Wallet putMoney(String idWallet, Double amount) throws ResourceNotFoundException;

}
