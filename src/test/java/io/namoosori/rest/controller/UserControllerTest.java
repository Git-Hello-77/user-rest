package io.namoosori.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.namoosori.rest.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @WebMvcTest 는 @SpringBootTest+@AutoConfigureMockMvc 보다 경량 테스트
 */
@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void register() throws Exception {
        User sample = User.sample();
        // User를 json으로 변환
        String content = objectMapper.writeValueAsString(sample);

        // MockMvc를 이용하여 post 로 /users 테스트
        mockMvc.perform(post("/users")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(sample.getId()))
                .andDo(print()
        );
    }

    @Test
    void find() {
    }

    @Test
    void findAll() {
    }

    @Test
    void modify() {
    }

    @Test
    void remove() {
    }
}