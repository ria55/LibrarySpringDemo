package progmatic.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import progmatic.models.LibraryUser;
import progmatic.returnModels.ReturnModel;

@RestController
//@RequestMapping("/Alexandra")
public class HomeController {

    @GetMapping(value = {"/", "/home"})
    public String getHome() {
        return "Welcome!";
    }

    @GetMapping("/testUser")
    public ReturnModel<LibraryUser> testApp() {
        //ResponseEntity<String> responseEntity = new ResponseEntity<>("Hello!", HttpStatus.OK);

        ReturnModel<LibraryUser> toReturn = new ReturnModel<>(
                true, HttpStatus.OK, new LibraryUser()
        );

        return toReturn;
    }

    @RequestMapping(value = "/title", method = RequestMethod.GET)
    public String getSomething() {
        return "I want to get.";
    }

    @RequestMapping(value = "/title", method = RequestMethod.POST)
    public String postSomething() {
        return "I want to post.";
    }

    @GetMapping(value = {"/user/{id}", "/user/"}) // localhost:8080/user/15
    public ReturnModel<LibraryUser> getUserById(
            @PathVariable(required = false) Integer id
    ) {
        //ResponseEntity<String> responseEntity = new ResponseEntity<>("Hello!", HttpStatus.OK);
        ReturnModel<LibraryUser> toReturn = new ReturnModel<>();
        if (id != null) {
            if (id > 5) {
                toReturn.setSuccess(true);
            }
        } else {
            toReturn.setSuccess(false);
        }

        return toReturn;
    }

    @GetMapping("/testRequestParam") // localhost:8080/testRequestParam?id=1&name=kiscica
    public ReturnModel<String> getRequestParam(
            @RequestParam(defaultValue = "1") Integer id,
            @RequestParam(defaultValue = "kiscica") String name
    ) {
        ReturnModel<String> toReturn = new ReturnModel<>();
        if (id != null) {
            if (name != null) {
                toReturn.setObject(name);
                toReturn.setSuccess(true);
            }
        } else {
            toReturn.setSuccess(false);
        }

        return toReturn;
    }

}
