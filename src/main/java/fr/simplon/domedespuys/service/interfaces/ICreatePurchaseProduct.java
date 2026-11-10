package fr.simplon.domedespuys.service.interfaces;

public interface ICreatePurchaseProduct<PurchaseProduct,Purchase,PurchaseProductDTO>{

    PurchaseProduct create (Purchase purchase,PurchaseProductDTO dto);
}
