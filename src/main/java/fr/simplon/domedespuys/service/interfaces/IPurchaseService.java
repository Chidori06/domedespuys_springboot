package fr.simplon.domedespuys.service.interfaces;

import fr.simplon.domedespuys.dto.PurchasePostDTO;
import fr.simplon.domedespuys.dto.PurchasePutDTO;
import fr.simplon.domedespuys.entity.Purchase;

public interface IPurchaseService extends
        ICollection<Purchase>,
        IGetItem<Purchase>,
        ICreate<Purchase, PurchasePostDTO>,
        IUpdate<Purchase, PurchasePutDTO>
{
}
