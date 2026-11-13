package fr.simplon.domedespuys.service.interfaces;

import fr.simplon.domedespuys.dto.AddressDTO;
import fr.simplon.domedespuys.entity.Address;

public interface IAddressService extends
    ICreate<Address, AddressDTO>,
    IUpdate<Address, AddressDTO>,
    IGetItem<Address>,
    IDelete

{
}
