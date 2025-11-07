package app.tracker.EveryDollar.services;

import app.tracker.EveryDollar.classes.UserAccount;
import app.tracker.EveryDollar.dtos.LoginDTO;
import app.tracker.EveryDollar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    //----------------------------------------------------------------------------------------------------
    // Logs a user in.

    public ResponseEntity<String> userLogin(LoginDTO loginDTO){
        UserAccount userAccount = userRepository.findByUsername(loginDTO.getUsername());

        if (userAccount == null) {
            return ResponseEntity.status(401).body("Invalid Username");
        }

        boolean matches = passwordEncoder.matches(loginDTO.getPassword(), userAccount.getPassword());

        if(!matches){
            return ResponseEntity.status(401).body("Invalid password");
        }

        return ResponseEntity.ok("Login successful!");
    }

    //----------------------------------------------------------------------------------------------------
    // Logs a user out.

    public ResponseEntity<String> userLogout(){
        return ResponseEntity.ok("Logged out successfully.");
    }


}
