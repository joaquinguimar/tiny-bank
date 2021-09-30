package es.jguimar.tinybankAPI.application.port.outbound;

import es.jguimar.tinybankAPI.domain.model.User;

public interface UserWriteRepository {

    User save(User user);

}
