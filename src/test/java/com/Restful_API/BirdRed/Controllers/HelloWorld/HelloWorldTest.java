package com.Restful_API.BirdRed.Controllers.HelloWorld;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class HelloWorldTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Deve retornar um \"200-OK\" e um emoji UTF-8 passáro vermelho!")
    void T1() throws Exception {
        mockMvc.perform(get("/HelloBird"))
                .andExpect(status().isOk())
                .andExpect(content().string("🐦"));

    }
}
