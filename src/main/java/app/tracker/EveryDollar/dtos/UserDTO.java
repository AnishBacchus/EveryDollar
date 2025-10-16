package app.tracker.EveryDollar.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String username;
    private String email;

    public UserDTO(){}

    public UserDTO(String username, String email){
        this.username = username;
        this.email = email;
    }

}
