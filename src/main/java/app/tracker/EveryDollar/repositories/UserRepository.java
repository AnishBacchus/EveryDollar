package app.tracker.EveryDollar.repositories;


import app.tracker.EveryDollar.classes.Transaction;
import app.tracker.EveryDollar.classes.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findById(Long id);
    UserAccount findByUsername(String username);
}
