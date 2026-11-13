package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class PurchaseProductDTO {

    @Min(value = 1, message = "La quantité doit être au moins de 1")
    @Max(value = 999, message = "La quantité ne peut pas dépasser 999 unités")
    public int quantity;

    @Min(value = 1L, message = "Le prix doit être de 1 minimum")
    @Max(value = 99999L, message = "Le prix doit être inférieur à 99999,99 maximum")
    public int price;

    @NotBlank(message = "Le produit doit être renseigné")
    public String idProduct;
}
