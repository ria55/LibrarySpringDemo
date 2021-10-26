package progmatic.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/home"})
    public String getHome() {
        return "index";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/user")
    public String getUserPage() {
        return "index";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public String getAdminPage() {
        return "index";
    }

    @PostMapping("/this-post-endpoint")
    public String postMethod(@ModelAttribute("username") String username,
                             @ModelAttribute("password") String password) {
        return "index";
    }

}
