package es.jguimar.tinybankAPI.application.usecase;

import es.jguimar.tinybankAPI.domain.model.Wallet;

import java.util.List;

public interface CreateWalletUseCase {

    /**
     * Creates a new wallet
     * @param userId list of users
     * @return The new wallet created
     */
    Wallet create(List<String> userId);

}
