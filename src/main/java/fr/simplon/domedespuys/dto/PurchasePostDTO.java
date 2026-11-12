package fr.simplon.domedespuys.dto;

import fr.simplon.domedespuys.entity.PurchaseProduct;

import java.util.List;

public class PurchasePostDTO {
    public String idAddress;
    public List<PurchaseProductDTO> orderProducts;
}
