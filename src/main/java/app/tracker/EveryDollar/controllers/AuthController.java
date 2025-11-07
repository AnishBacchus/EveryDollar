package app.tracker.EveryDollar.controllers;

import app.tracker.EveryDollar.dtos.LoginDTO;
import app.tracker.EveryDollar.services.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    LoginService loginService;

    //----------------------------------------------------------------------------------------------------
    // Logs a user in.

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginDTO){
        return loginService.userLogin(loginDTO);
    }

    //----------------------------------------------------------------------------------------------------
    // Logs a user out. (PLACEHOLDER FOR NOW)

    @PostMapping("/logout")
    public ResponseEntity<String> logut(){
        return loginService.userLogout();
    }

}
