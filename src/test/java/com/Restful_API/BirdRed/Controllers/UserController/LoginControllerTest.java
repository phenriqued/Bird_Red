package com.Restful_API.BirdRed.Controllers.UserController;


import com.Restful_API.BirdRed.DTOs.User.SignUp.UserSingUpDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters

public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JacksonTester<UserSingUpDTO> UserSignUpDTOJsonTest;

    @Test
    @DisplayName("should return the code \"201 created\" when information User is valid")
    void T1() throws Exception {
        mockMvc.perform(post("/login/singup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(UserSignUpDTOJsonTest.write(
                        new UserSingUpDTO("teste", "test", "test123")
                ).getJson()))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("should return the code \"200 ok\" when information User is valid")
    void T2() throws Exception {
        mockMvc.perform(post("/login/singin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(UserSignUpDTOJsonTest.write(
                                new UserSingUpDTO("testeErrado", "jonas", "test123")
                        ).getJson()))
                .andExpect(status().isUnauthorized());
    }



}

