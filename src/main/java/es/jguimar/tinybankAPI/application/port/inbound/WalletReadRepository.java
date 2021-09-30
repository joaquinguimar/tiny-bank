package es.jguimar.tinybankAPI.application.port.inbound;

import es.jguimar.tinybankAPI.domain.model.User;
import es.jguimar.tinybankAPI.domain.model.Wallet;

import java.util.Optional;

public interface WalletReadRepository {

    Optional<Wallet> findById(String id);

}
