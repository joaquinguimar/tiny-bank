package es.jguimar.tinybankAPI.application.service;

import es.jguimar.tinybankAPI.application.port.inbound.WalletReadRepository;
import es.jguimar.tinybankAPI.application.port.outbound.WalletWriteRepository;
import es.jguimar.tinybankAPI.application.usecase.CreateWalletUseCase;
import es.jguimar.tinybankAPI.application.usecase.PutMoneyUseCase;
import es.jguimar.tinybankAPI.application.usecase.ShowWalletUseCase;
import es.jguimar.tinybankAPI.application.usecase.TransferMoneyUseCase;
import es.jguimar.tinybankAPI.domain.model.Wallet;
import es.jguimar.tinybankAPI.infrastructure.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor //Constructor-Based Dependency Injection
public class WalletService implements CreateWalletUseCase, PutMoneyUseCase, ShowWalletUseCase, TransferMoneyUseCase {

    public static final double INITIAL_TOTAL_AMOUNT = 0.0;
    public static final ArrayList<Double> INITIAL_MOVEMENTS = new ArrayList<>();


    private final WalletReadRepository walletReadRepository;

    private final WalletWriteRepository walletWriteRepository;

    @Override
    public Wallet putMoney(String idWallet, Double amount) throws ResourceNotFoundException {
        return setMoneyToWallet(findWallet(idWallet), amount);
    }

    @Override
    public Wallet create(List<String> userId) {
        return walletWriteRepository.save(
                Wallet.builder()
                        .userIds(userId)
                        .movements(INITIAL_MOVEMENTS)
                        .totalAmount(INITIAL_TOTAL_AMOUNT).build());
    }

    @Override
    public Wallet showWallet(String id) throws ResourceNotFoundException {
        return findWallet(id);
    }

    @Override
    public Wallet transferMoney(String idAccountSource, String idAccountTarget, Double amount) throws ResourceNotFoundException {
        Wallet sourceWallet = findWallet(idAccountSource);
        Wallet targetWallet = findWallet(idAccountTarget);
        setMoneyToWallet(sourceWallet, -amount);
        setMoneyToWallet(targetWallet, amount);
        walletWriteRepository.save(sourceWallet);
        return walletWriteRepository.save(targetWallet);
    }

    private Wallet findWallet(String id) throws ResourceNotFoundException {
        Optional<Wallet> byId = walletReadRepository.findById(id);
        if (byId.isEmpty()) {
            throw new ResourceNotFoundException();
        } else {
            return byId.get();
        }
    };

    private Wallet setMoneyToWallet(Wallet wallet, Double amount) {
        if (Objects.isNull(wallet.getMovements()) || wallet.getMovements().isEmpty()) {
            wallet.setMovements(new ArrayList<>());
        }
        wallet.getMovements().add(amount);
        wallet.updateTotalAmount();
        walletWriteRepository.save(wallet);
        return wallet;
    }
}
