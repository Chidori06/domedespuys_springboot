package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.AddressDTO;
import fr.simplon.domedespuys.entity.Address;
import fr.simplon.domedespuys.repository.AddressRepository;
import fr.simplon.domedespuys.service.interfaces.IAddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Service
@AllArgsConstructor
public class AddressServiceImpl implements IAddressService {

    private final AddressRepository addressRepository;

    @Override
    public Address create(AddressDTO dto) {
        //Penser au CreatedAt et User
        Address address = new Address();
        dtoToObject(dto, address);
        address.setCreatedAt(LocalDateTime.now());
        //address.setUser();
        addressRepository.saveAndFlush(address);
        return address;
    }

    private Address getById(String id) {
        return addressRepository.findById(Long.parseLong(id)).orElse(null);
    }

    @Override
    public Address update(String id, AddressDTO dto) {
        Address address = getById(id);
        if(address != null){
            dtoToObject(dto, address);
            addressRepository.saveAndFlush(address);
        }
        return address;
    }

    @Override
    public boolean delete(String id) {
        try {
            addressRepository.deleteById(Long.parseLong(id));
            return true;
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
        return false;

    }

    private void dtoToObject(AddressDTO dto, Address address){
        address.setLine(dto.line);
        address.setExtraLine(dto.extraLine);
        address.setZipCode(dto.zipCode);
        address.setCity(dto.city);
        address.setCountry(dto.country);
        address.setPhone(dto.phone);
        address.setFirstname(dto.firstname);
        address.setLastname(dto.lastname);
    }
}
