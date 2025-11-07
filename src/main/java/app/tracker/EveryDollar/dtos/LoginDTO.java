package app.tracker.EveryDollar.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {

    @NotBlank(message = "Size must be between 5-20.")
    @Size(min = 5, max = 20)
    private String username;

    @NotBlank(message = "Size must be between 5-20.")
    @Size(min = 5, max = 20)
    private String password;
}
