package testHelpers;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import progmatic.models.LibraryUser;

import java.util.Arrays;

@TestConfiguration
public class TestConfig {

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        LibraryUser user = createUser("user@user.com", "user", "user");
        LibraryUser admin = createUser("admin@admin.com", "admin", "admin");

        return new InMemoryUserDetailsManager(Arrays.asList(user, admin));
    }

    private LibraryUser createUser(String email, String password, String role) {
        LibraryUser user = new LibraryUser();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

        return user;
    }

}
