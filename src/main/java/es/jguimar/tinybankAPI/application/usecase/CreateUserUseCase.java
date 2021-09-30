package es.jguimar.tinybankAPI.application.usecase;

import es.jguimar.tinybankAPI.domain.model.User;
import es.jguimar.tinybankAPI.infrastructure.exception.ResourceExistsException;

public interface CreateUserUseCase {

     /**
      * Creates a new user based on a non-empty name and a password.
      * @param user - Object with data user
      * @return New user created
      * @throws ResourceExistsException
      */
     User create(User user) throws ResourceExistsException;

}
