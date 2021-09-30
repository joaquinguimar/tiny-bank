package es.jguimar.tinybankAPI.application.service;

import es.jguimar.tinybankAPI.adapter.rest.dto.UserRequestDto;
import es.jguimar.tinybankAPI.adapter.rest.dto.UserResponseDto;
import es.jguimar.tinybankAPI.adapter.rest.tranform.UserMapper;
import es.jguimar.tinybankAPI.application.port.inbound.UserReadRepository;
import es.jguimar.tinybankAPI.application.port.outbound.UserWriteRepository;
import es.jguimar.tinybankAPI.application.usecase.CreateUserUseCase;
import es.jguimar.tinybankAPI.domain.model.User;
import es.jguimar.tinybankAPI.infrastructure.exception.ResourceExistsException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor //Constructor-Based Dependency Injection
public class CreateUserService implements CreateUserUseCase {

    private final UserReadRepository userReadRepository;

    private final UserWriteRepository userWriteRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto create(UserRequestDto user) throws ResourceExistsException {
        if (!userReadRepository.findByName(user.getName()).isEmpty()) {
           throw new ResourceExistsException();
        } else {
            return userMapper.toUserResponseDto(
                    userWriteRepository.save(User.builder()
                            .name(user.getName())
                            .password(passwordEncoder.encode(user.getPassword()))
                            .build()));
        }
    }
}
