package es.jguimar.tinybankAPI.adapter.mongo;

import es.jguimar.tinybankAPI.application.port.inbound.UserReadRepository;
import es.jguimar.tinybankAPI.application.port.outbound.UserWriteRepository;
import es.jguimar.tinybankAPI.domain.model.User;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class UserRepositoryImpl implements UserWriteRepository, UserReadRepository {

    private UserMongoRepository userMongoRepository;

    @Override
    public Optional<User> findByName(String name) {
        return userMongoRepository.findByName(name);
    }

    @Override
    public Optional<User> findById(String id) {
        return userMongoRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userMongoRepository.save(user);
    }
}
