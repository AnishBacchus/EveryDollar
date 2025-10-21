package app.tracker.EveryDollar.repositories;

import app.tracker.EveryDollar.classes.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserAccountId(Long id);
    List<Transaction> findByUserAccountIdAndItem(Long id, String item);
    List<Transaction> findByUserAccountIdAndItemContainingIgnoreCase(Long id, String item);
    List<Transaction> findByUserAccountIdAndAmount(Long id, Double cost);
    List<Transaction> findByUserAccountIdAndCategory(Long id, String category);
}
