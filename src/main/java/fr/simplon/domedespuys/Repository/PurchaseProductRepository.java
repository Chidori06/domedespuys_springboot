package fr.simplon.domedespuys.Repository;

import fr.simplon.domedespuys.Entity.PurchaseProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseProductRepository extends JpaRepository<PurchaseProduct, Long> {
}
