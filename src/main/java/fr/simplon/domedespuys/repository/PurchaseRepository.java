package fr.simplon.domedespuys.repository;

import fr.simplon.domedespuys.entity.Address;
import fr.simplon.domedespuys.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository  extends JpaRepository<Purchase, Long> {

    List<Purchase> findAllByAddress(Address address);
}
