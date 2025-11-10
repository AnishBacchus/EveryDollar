package app.tracker.EveryDollar.user;

import app.tracker.EveryDollar.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;


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

        String token = jwtService.generateToken(userAccount.getUsername());
        return ResponseEntity.ok(token);
    }

    //----------------------------------------------------------------------------------------------------
    // Logs a user out.

    public ResponseEntity<String> userLogout(){
        return ResponseEntity.ok("Logged out successfully.");
    }


}
