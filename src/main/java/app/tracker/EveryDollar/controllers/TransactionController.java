package app.tracker.EveryDollar.controllers;

import app.tracker.EveryDollar.classes.Transaction;
import app.tracker.EveryDollar.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "*")
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

    //----------------------------------------------------------------------------------------------------
    // Get a specific transaction for a user.

    @GetMapping("/search/{item}")
    public ResponseEntity<List<Transaction>> getTransactionsByItem(@PathVariable("id") Long id, @PathVariable String item){
        return transactionService.getTransactionsByItem(id, item);
    }

    //----------------------------------------------------------------------------------------------------
    // Get transactions from a certain category for a user.

    @GetMapping("/{category}")
    public ResponseEntity<List<Transaction>> getTransactionByCategory(@PathVariable("id")Long id, @PathVariable String category){
        return transactionService.getAllTransactionsByCategory(id, category);
    }

    //----------------------------------------------------------------------------------------------------
    // Update user's total transaction amount.

    @PutMapping("/amount/{oldAmount}/{newAmount}")
    public ResponseEntity<String> updateTransactionAmount(@PathVariable("id") Long id, @PathVariable Double oldAmount, @PathVariable Double newAmount) {
        return transactionService.updateTransaction(id, oldAmount, newAmount);
    }


    //----------------------------------------------------------------------------------------------------
    // Delete a user transaction.

    @DeleteMapping("/remove/{item}")
    public ResponseEntity<String> removeTransaction(@PathVariable("id")Long id, @PathVariable String item) {
        return transactionService.removeTransaction(id, item);
    }


}
