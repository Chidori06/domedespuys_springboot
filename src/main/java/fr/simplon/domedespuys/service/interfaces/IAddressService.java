package fr.simplon.domedespuys.service.interfaces;

import fr.simplon.domedespuys.dto.AddressDTO;
import fr.simplon.domedespuys.entity.Address;
import fr.simplon.domedespuys.service.interfaces.dao.ICreate;
import fr.simplon.domedespuys.service.interfaces.dao.IDelete;
import fr.simplon.domedespuys.service.interfaces.dao.IGetItem;
import fr.simplon.domedespuys.service.interfaces.dao.IUpdate;

public interface IAddressService extends
        ICreate<Address, AddressDTO>,
        IUpdate<Address, AddressDTO>,
        IGetItem<Address>,
        IDelete

{
}
