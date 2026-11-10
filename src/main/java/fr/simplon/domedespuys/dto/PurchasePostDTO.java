package fr.simplon.domedespuys.dto;

import fr.simplon.domedespuys.entity.PurchaseProduct;

import java.util.List;

public class PurchasePostDTO {
    public Long idAddress;
    public List<PurchaseProductDTO> orderProducts;
}
