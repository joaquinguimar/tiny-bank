package es.jguimar.tinybankAPI.adapter.mongo;

import es.jguimar.tinybankAPI.domain.model.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WalletMongoRepository extends MongoRepository<Wallet, String> {

}
