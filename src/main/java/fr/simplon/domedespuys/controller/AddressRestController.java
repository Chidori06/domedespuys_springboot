package fr.simplon.domedespuys.controller;

import fr.simplon.domedespuys.entity.Address;
import fr.simplon.domedespuys.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/address")
public class AddressRestController {

    private final AddressRepository addressRepository;

    @GetMapping
    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Address> getAddressById(@PathVariable String id){
        return addressRepository.findById(Long.valueOf(id));
    }
}
