package es.jguimar.tinybankAPI.adapter.rest;


import es.jguimar.tinybankAPI.adapter.rest.UserController;
import es.jguimar.tinybankAPI.adapter.rest.dto.UserResponseDto;
import es.jguimar.tinybankAPI.application.service.CreateUserService;
import es.jguimar.tinybankAPI.infrastructure.exception.ResourceExistsException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CreateUserService userService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController(userService)).build();
    }

    @Test
    public void createNewUser_shouldReturnOk() throws Exception {
        // Given
        given(userService.create(any()))
                .willReturn(UserResponseDto.builder().id("abc1234").build());

        // When
        final ResultActions result = mockMvc.perform(
                post("/user/")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"name\": \"Secure safebox 05\",\n" +
                                "  \"password\": \"extremelySecurePassword\"\n" +
                                "}"));

        // Then
        result.andExpect(status().isOk());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.id").value("abc1234"));
    }

    @Test
    public void createNewUserDuplicated_shouldReturnKO() throws Exception {

        // Given
        given(userService.create(any()))
                .willThrow(new ResourceExistsException());

        // When
        final ResultActions result = mockMvc.perform(
                post("/user/")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"name\": \"Secure safebox 05\",\n" +
                                "  \"password\": \"extremelySecurePassword\"\n" +
                                "}"));

        // Then
        result.andExpect(status().isConflict());
    }

    //TODO: More test cases
}