package progmatic.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import progmatic.models.LibraryUser;
import progmatic.returnModels.ReturnModel;

@RestController
public class UserController {

    @PostMapping("/register")
    public ReturnModel<String> registerNewUser(
            @RequestBody LibraryUser user
    ) {
        // itt rögzítem az adatbázisba az új felhasználót
        ReturnModel<String> toReturn = new ReturnModel<>();
        toReturn.setObject("felhasználó rögzítve");

        return toReturn;
    }

    @GetMapping("/test-user/{id}")
    public ResponseEntity<LibraryUser> getUser(
            @PathVariable Long id
    ) {
        LibraryUser user = new LibraryUser();
        user.setRole("role");
        user.setEmail("user@mail.com");

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/test-string")
    public ResponseEntity<String> getString() {
        return new ResponseEntity<>("Hello, world!", HttpStatus.OK);
    }

}
