package progmatic.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import testHelpers.TestConfig;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = TestConfig.class)
@AutoConfigureMockMvc
class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getHome() throws Exception {
        mockMvc.perform(get("/home"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getInvalidEndpoint() throws Exception {
        mockMvc.perform(get("/this-is-an-invalid-end-point"))
                .andExpect(status().is(404))
                .andReturn();
    }

    @Test
    void getUserPageWithoutLogin() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/user"))
                .andExpect(status().is(302))
                .andReturn();

        assertHeaderContains(mvcResult, "Location", "login");
    }

    @Test
    @WithUserDetails("user@user.com")
    void getUserPageWithUser() throws Exception {
        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @WithUserDetails("admin@admin.com")
    void getUserPageWithAdmin() throws Exception {
        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getAdminPageWithoutLogin() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/admin"))
                .andExpect(status().is(302))
                .andReturn();

        assertHeaderContains(mvcResult, "Location", "login");
    }

    @Test
    @WithUserDetails("user@user.com")
    void getAdminPageWithUser() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().is(403))
                .andReturn();
    }

    @Test
    @WithUserDetails("admin@admin.com")
    void getAdminPageWithAdmin() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testPostMapping() throws Exception {
        mockMvc.perform(
                post("/this-post-endpoint")
                    .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                        // username:admin
                        // password:password
                    .content("username:admin\npassword:password"))
                .andExpect(status().isOk())
                .andReturn();
    }

    private void assertHeaderContains(MvcResult mvcResult, String header, String containText) {
        String location = mvcResult.getResponse().getHeader(header);

        assertNotNull(location);
        assertTrue(location.contains(containText));
    }

}