package fr.simplon.domedespuys.service.interfaces;

import fr.simplon.domedespuys.dto.PurchaseProductDTO;
import fr.simplon.domedespuys.entity.Purchase;
import fr.simplon.domedespuys.entity.PurchaseProduct;

public interface IPurchaseProductService
{
    PurchaseProduct create (Purchase purchase, PurchaseProductDTO purchaseProductDTO);
}
