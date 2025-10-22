package app.tracker.EveryDollar.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {

    private String username;
    private String email;


    public UserResponseDTO() {
    }

    public UserResponseDTO(String username, String email) {
        this.username = username;
        this.email = email;
    }

}
