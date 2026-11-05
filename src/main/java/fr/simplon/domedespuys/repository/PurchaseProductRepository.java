package fr.simplon.domedespuys.repository;

import fr.simplon.domedespuys.entity.PurchaseProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseProductRepository extends JpaRepository<PurchaseProduct, Long> {
}
