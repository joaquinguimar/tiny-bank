package es.jguimar.tinybankAPI.application.usecase;

import es.jguimar.tinybankAPI.adapter.rest.dto.UserRequestDto;
import es.jguimar.tinybankAPI.adapter.rest.dto.UserResponseDto;
import es.jguimar.tinybankAPI.infrastructure.exception.ResourceExistsException;

public interface CreateUserUseCase {

     UserResponseDto create(UserRequestDto user) throws ResourceExistsException;

}
