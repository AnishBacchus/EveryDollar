package app.tracker.EveryDollar.controllers;

import app.tracker.EveryDollar.classes.UserAccount;
import app.tracker.EveryDollar.dtos.UserDTO;
import app.tracker.EveryDollar.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //----------------------------------------------------------------------------------------------------
    // Creates a User account.

    @PostMapping("/create")
    public ResponseEntity<String> addUser(@RequestBody UserAccount userAccount) {
        return userService.create(userAccount);
    }

    //----------------------------------------------------------------------------------------------------
    // Get a user's username and email.

    @GetMapping("/{id}/account")
    public ResponseEntity<UserDTO> getUserDetails(@PathVariable Long id) {
        return userService.getAccount(id);
    }

}
