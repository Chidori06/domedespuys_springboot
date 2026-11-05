package fr.simplon.domedespuys.repository;

import fr.simplon.domedespuys.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
