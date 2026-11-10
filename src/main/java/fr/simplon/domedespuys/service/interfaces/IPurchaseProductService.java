package fr.simplon.domedespuys.service.interfaces;

import fr.simplon.domedespuys.dto.PurchaseProductDTO;
import fr.simplon.domedespuys.entity.Purchase;
import fr.simplon.domedespuys.entity.PurchaseProduct;

public interface IPurchaseProductService extends
    ICreatePurchaseProduct<PurchaseProduct,Purchase, PurchaseProductDTO>
{
}
