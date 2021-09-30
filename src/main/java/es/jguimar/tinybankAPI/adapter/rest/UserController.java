package es.jguimar.tinybankAPI.adapter.rest;

import es.jguimar.tinybankAPI.adapter.rest.dto.UserRequestDto;
import es.jguimar.tinybankAPI.adapter.rest.dto.UserResponseDto;
import es.jguimar.tinybankAPI.application.port.inbound.UserWeb;
import es.jguimar.tinybankAPI.application.service.CreateUserService;
import es.jguimar.tinybankAPI.infrastructure.exception.ResourceExistsException;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


@RestController
@Api(value = "API tiny bank poc", tags = { "User" })
@AllArgsConstructor //Constructor-Based Dependency Injection
public class UserController implements UserWeb {

    private final CreateUserService createUserService;

    @Override
    public UserResponseDto userPost(@Valid UserRequestDto body) {
        try {
            return createUserService.create(body);
        } catch (ResourceExistsException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }
}
