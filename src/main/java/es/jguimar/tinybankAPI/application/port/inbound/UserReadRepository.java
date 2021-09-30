package es.jguimar.tinybankAPI.application.port.inbound;

import es.jguimar.tinybankAPI.domain.model.User;

import java.util.Optional;

public interface UserReadRepository {

    Optional<User> findByName(String name);

    Optional<User> findById(String id);

}
