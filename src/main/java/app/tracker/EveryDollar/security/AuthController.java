package app.tracker.EveryDollar.security;

import app.tracker.EveryDollar.user.LoginDTO;
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
    AuthService authService;

    //----------------------------------------------------------------------------------------------------
    // Logs a user in.

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginDTO){
        return authService.login(loginDTO.getUsername(), loginDTO.getPassword());
    }

    //----------------------------------------------------------------------------------------------------
    // Logs a user out. (PLACEHOLDER FOR NOW)

    @PostMapping("/logout")
    public ResponseEntity<String> logut(){
        return ResponseEntity.ok("Logged out sucessfully.");
    }

}
