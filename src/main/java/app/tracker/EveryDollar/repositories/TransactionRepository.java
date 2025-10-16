package app.tracker.EveryDollar.repositories;

import app.tracker.EveryDollar.classes.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserAccountId(Long id);
}
