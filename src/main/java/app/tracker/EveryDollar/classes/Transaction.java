package app.tracker.EveryDollar.classes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String item;
    private double amount;
    private String category;
    private String description;
    private LocalDate date;


    @ManyToOne
    @JoinColumn(name = "user_account_id")
    @JsonBackReference
    private UserAccount userAccount;
}
