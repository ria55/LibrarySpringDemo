package progmatic.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import progmatic.models.LibraryUser;

@Service
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO
        LibraryUser user = new LibraryUser();
        user.setRole("admin");
        user.setEmail("admin@admin.com");
        user.setPassword("admin");
        return user;
    }

}
