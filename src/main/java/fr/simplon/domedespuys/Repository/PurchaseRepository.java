package fr.simplon.domedespuys.Repository;

import fr.simplon.domedespuys.Entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository  extends JpaRepository<Purchase, Long> {
}
