package app.tracker.EveryDollar.transaction;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class TransactionDTO {

    @NotBlank(message = "Item name is required.")
    @Size(min = 1, max = 30)
    private String item;

    @NotNull(message = "Amount is required.")
    private double amount;

    @NotBlank(message = "Category is required.")
    @Size(min = 1, max = 30)
    private String category;

    @NotBlank(message = "Description is required.")
    @Size(min = 5, max = 100)
    private String description;

    @NotNull(message = "Date is required.")
    private LocalDate date;

}
