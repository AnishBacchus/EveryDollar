package app.tracker.EveryDollar.controllers;

import app.tracker.EveryDollar.classes.Transaction;
import app.tracker.EveryDollar.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/users/{id}/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    //----------------------------------------------------------------------------------------------------
    // Creates a transaction for a user.

    @PostMapping
    public ResponseEntity<String> addNewTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        return transactionService.addTransaction(id, transaction);
    }

    //----------------------------------------------------------------------------------------------------
    // Get a user's transactions.

    @GetMapping
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable Long id) {
        return transactionService.getUserTransactions(id);
    }

    //----------------------------------------------------------------------------------------------------
    // Get a user's total transaction costs.

    @GetMapping("/total")
    public ResponseEntity<Double> getTotalTransactionCosts(@PathVariable("id") Long id) { //@PathVariable("id"): PathVariable at class level.
        return transactionService.getTotalTransactions(id);
    }
}
