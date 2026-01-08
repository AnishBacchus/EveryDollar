package app.tracker.EveryDollar.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //----------------------------------------------------------------------------------------------------
    // Creates a User account.

    public ResponseEntity<String> create(UserCreateDTO userDTO) {
        UserAccount user = new UserAccount();

        user.setName(userDTO.getName());
        user.setUsername(userDTO.getUsername());
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(encodedPassword);
        user.setEmail(userDTO.getEmail());

        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User account created!");
    }

    //----------------------------------------------------------------------------------------------------
    // Get a user's username and email.

    public ResponseEntity<UserResponseDTO> getAccount(Long userID) {
        Optional<UserAccount> userAccountOptional = userRepository.findById(userID);

        if (userAccountOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        UserAccount user = userAccountOptional.get();
        return ResponseEntity.status(HttpStatus.OK).body(new UserResponseDTO(user.getUsername(), user.getEmail()));
    }

    //----------------------------------------------------------------------------------------------------
    // Method to find user by their id.

    public Optional<UserAccount> findById(Long id) {
        return userRepository.findById(id);
    }

}
