package es.jguimar.tinybankAPI.adapter.mongo;

import es.jguimar.tinybankAPI.domain.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserMongoRepository extends MongoRepository<User, String> {

    Optional<User> findByName(String name);

}
