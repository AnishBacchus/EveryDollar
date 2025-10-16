package app.tracker.EveryDollar.services;

import app.tracker.EveryDollar.classes.UserAccount;
import app.tracker.EveryDollar.dtos.UserDTO;
import app.tracker.EveryDollar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //----------------------------------------------------------------------------------------------------
    // Creates a User account.

    public ResponseEntity<String> create(UserAccount user) {
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User account created!");
    }

    //----------------------------------------------------------------------------------------------------
    // Get a user's username and email.

    public ResponseEntity<UserDTO> getAccount(Long userID) {
        Optional<UserAccount> userAccountOptional = userRepository.findById(userID);

        if (userAccountOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        UserAccount user = userAccountOptional.get();
        return ResponseEntity.status(HttpStatus.OK).body(new UserDTO(user.getUsername(), user.getEmail()));
    }

    //----------------------------------------------------------------------------------------------------
    // Method to find user by their id.

    public Optional<UserAccount> findById(Long id) {
        return userRepository.findById(id);
    }

}
