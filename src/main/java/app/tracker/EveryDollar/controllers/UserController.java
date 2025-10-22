package app.tracker.EveryDollar.controllers;

import app.tracker.EveryDollar.classes.UserAccount;
import app.tracker.EveryDollar.dtos.UserCreateDTO;
import app.tracker.EveryDollar.dtos.UserResponseDTO;
import app.tracker.EveryDollar.services.UserService;
import jakarta.validation.Valid;
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
    public ResponseEntity<String> addUser(@Valid @RequestBody UserCreateDTO userDTO) {
        return userService.create(userDTO);
    }

    //----------------------------------------------------------------------------------------------------
    // Get a user's username and email.

    @GetMapping("/{id}/account")
    public ResponseEntity<UserResponseDTO> getUserDetails(@PathVariable Long id) {
        return userService.getAccount(id);
    }

}
