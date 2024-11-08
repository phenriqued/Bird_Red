package com.Restful_API.BirdRed.Controllers.UserController;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc

public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("should return the code \"201 created\" when information User is valid")
    void T1(){

    }
}

