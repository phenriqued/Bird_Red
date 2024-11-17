package com.Restful_API.BirdRed.Controllers.UserController;


import com.Restful_API.BirdRed.DTOs.User.SignUp.UserSignUpDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters

public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JacksonTester<UserSignUpDTO> UserSignUpDTOJsonTest;

    @Test
    @DisplayName("should return the code \"201 created\" when information User is valid")
    void T1() throws Exception {
        mockMvc.perform(post("/login/singup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(UserSignUpDTOJsonTest.write(
                        new UserSignUpDTO("teste", "test", "test123")
                ).getJson()))
                .andExpect(status().isCreated());
    }
}

