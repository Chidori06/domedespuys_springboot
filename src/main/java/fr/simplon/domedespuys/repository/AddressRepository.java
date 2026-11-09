package fr.simplon.domedespuys.repository;

import fr.simplon.domedespuys.entity.Address;
import fr.simplon.domedespuys.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAllByUser(User user);
}
