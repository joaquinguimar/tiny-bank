package es.jguimar.tinybankAPI.application.usecase;

import es.jguimar.tinybankAPI.adapter.rest.dto.UserRequestDto;
import es.jguimar.tinybankAPI.adapter.rest.dto.UserResponseDto;
import es.jguimar.tinybankAPI.adapter.rest.tranform.UserMapper;
import es.jguimar.tinybankAPI.application.port.inbound.UserReadRepository;
import es.jguimar.tinybankAPI.application.port.outbound.UserWriteRepository;
import es.jguimar.tinybankAPI.application.service.CreateUserService;
import es.jguimar.tinybankAPI.domain.model.User;
import es.jguimar.tinybankAPI.infrastructure.exception.ResourceExistsException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
public class CreateUserUseCaseTest {

    @Mock
    private UserReadRepository userReadRepository;

    @Mock
    private UserWriteRepository userWriteRepository;

    @Mock
    private UserMapper userMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    private CreateUserUseCase createUserUserCase;

    @Before
    public void setup() {
        createUserUserCase = new CreateUserService(userReadRepository, userWriteRepository,
                userMapper, passwordEncoder);
    }

    @Test
    public void createNewSafebox_shouldReturnOk() throws Exception {

        // Given
        given(userReadRepository.findByName(any()))
                .willReturn(Optional.empty());

        given(userWriteRepository.save(any()))
                .willReturn(User.builder().id("abc1234").build());

        given(passwordEncoder.encode(any())).willReturn("passenco1234");

        given(userMapper.toUserResponseDto(any()))
                .willReturn(UserResponseDto.builder().id("abc1234").build());


        // When
        UserResponseDto userRequestDto = createUserUserCase.create(UserRequestDto.builder()
                .name("abc1234").password("pass1234").build());

        // Then
        verify(userReadRepository, times(1)).findByName(eq("abc1234"));
        verify(userWriteRepository, times(1)).save(any());
        verify(passwordEncoder, times(1)).encode(eq("pass1234"));
        verify(userMapper, times(1)).toUserResponseDto(any());
        assertThat(userRequestDto.getId()).isEqualTo("abc1234");
    }

    @Test
    public void createNewSafebox_shouldReturnKO() throws Exception {

        // Given
        given(userReadRepository.findByName(any()))
                .willReturn(Optional.of(User.builder().id("abc1234").build()));

        // When
        Exception exception = assertThrows(ResourceExistsException.class, () -> {
            createUserUserCase.create(UserRequestDto.builder().name("abc1234").build());
         });

        // Then
        verify(userReadRepository, times(1)).findByName(eq("abc1234"));
        assertThat(exception.getMessage()).isNull();
    }

    //TODO: End up test cases

}