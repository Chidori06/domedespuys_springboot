package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.AddressDTO;
import fr.simplon.domedespuys.entity.Address;
import fr.simplon.domedespuys.service.interfaces.IAddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements IAddressService {
    @Override
    public Address create(AddressDTO dto) {
        //Penser au CreatedAt et User
        return null;
    }

    @Override
    public Address update(String id, AddressDTO dto) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
