package es.jguimar.tinybankAPI.adapter.mongo;

import es.jguimar.tinybankAPI.application.port.inbound.WalletReadRepository;
import es.jguimar.tinybankAPI.application.port.outbound.WalletWriteRepository;
import es.jguimar.tinybankAPI.domain.model.Wallet;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class WalletRepositoryImpl implements WalletReadRepository, WalletWriteRepository {

    private WalletMongoRepository walletMongoRepository;

    @Override
    public Wallet save(Wallet wallet) {
        return walletMongoRepository.save(wallet);
    }

    @Override
    public Optional<Wallet> findById(String id) {
        return walletMongoRepository.findById(id);
    }
}
