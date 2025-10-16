package app.tracker.EveryDollar.services;


import app.tracker.EveryDollar.classes.Transaction;
import app.tracker.EveryDollar.classes.UserAccount;
import app.tracker.EveryDollar.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserService userService;

    //----------------------------------------------------------------------------------------------------
    // Creates a transaction for a user.

    public ResponseEntity<String> addTransaction(Long id, Transaction transaction) {
        Optional<UserAccount> userAccountOptional = userService.findById(id);

        if (userAccountOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User is not found");
        }

        UserAccount user = userAccountOptional.get();
        transaction.setUserAccount(user);
        transactionRepository.save(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body("Transaction added to user!");
    }

    //----------------------------------------------------------------------------------------------------
    // Get a user's transactions.

    public ResponseEntity<List<Transaction>> getUserTransactions(Long id) {
        List<Transaction> userTransactions = transactionRepository.findByUserAccountId(id);

        if (userTransactions.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userTransactions);
        }

        return ResponseEntity.ok(userTransactions);

    }

    //----------------------------------------------------------------------------------------------------
    // Get a user's total transaction costs.

    public ResponseEntity<Double> getTotalTransactions(Long id) {
        List<Transaction> userTransactions = transactionRepository.findByUserAccountId(id);

        double total = userTransactions.stream().mapToDouble(Transaction::getAmount).sum();
        return ResponseEntity.ok(total);

    }

    //----------------------------------------------------------------------------------------------------
    // Update user's total transaction costs.

    public ResponseEntity<String> updateTransaction(Long id, Double cost, Double newCost) {
        List<Transaction> userTransactions = transactionRepository.findByUserAccountIdAndAmount(id, cost);

        if (userTransactions.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Wrong cost.");
        }

        Transaction existingTransaction = userTransactions.get(0);
        existingTransaction.setAmount(newCost);
        transactionRepository.save(existingTransaction);

        return ResponseEntity.status(HttpStatus.OK).body("Cost updated.");

    }

    //----------------------------------------------------------------------------------------------------
    // Delete a user transaction.

    public ResponseEntity<String> removeTransaction(Long id, String item) {
        List<Transaction> userTransactions = transactionRepository.findByUserAccountIdAndItem(id, item);

        if (userTransactions.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User has no transactions.");
        }

        transactionRepository.delete(userTransactions.get(0));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
