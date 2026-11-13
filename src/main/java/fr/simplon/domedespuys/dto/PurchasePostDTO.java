package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class PurchasePostDTO {

    @NotBlank(message = "L'adresse doit être renseignée")
    public String idAddress;

    public List<PurchaseProductDTO> orderProducts;
}
