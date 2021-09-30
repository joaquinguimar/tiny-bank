package es.jguimar.tinybankAPI.application.usecase;

import es.jguimar.tinybankAPI.domain.model.Wallet;

import java.util.List;

public interface CreateWalletUseCase {

    Wallet create(List<String> userId);
}
