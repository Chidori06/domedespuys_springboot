package fr.simplon.domedespuys.Repository;

import fr.simplon.domedespuys.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
