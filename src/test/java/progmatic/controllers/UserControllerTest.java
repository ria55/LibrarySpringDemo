package progmatic.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.web.servlet.MockMvc;
import testHelpers.TestConfig;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TestConfig.class)
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getHome() throws Exception {
        mockMvc.perform(
                SecurityMockMvcRequestBuilders.formLogin().user("admin@admin.com").password("admin"))
                .andExpect(SecurityMockMvcResultMatchers.authenticated());
    }

    @Test
    void getLogin() throws Exception {
        mockMvc.perform(post("/login")
        .contentType("multipart/form")
        .content("username:admin@admin.com\npassword:admin"))
        .andExpect(status().isOk())
        .andReturn();
    }

}