package es.jguimar.tinybankAPI.application.port.outbound;

import es.jguimar.tinybankAPI.domain.model.Wallet;

public interface WalletWriteRepository {

    Wallet save(Wallet user);

}
