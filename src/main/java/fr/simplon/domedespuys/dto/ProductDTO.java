package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class ProductDTO {

    @NotBlank(message = "Le nom du produit doit être renseigné")
    public String label;

    public String description;

    @Min(value = 1L, message = "Le prix doit être de 1 minimum")
    @Max(value = 30000L, message = "Le prix doit être inférieur à 30000,00 maximum")
    public int price;

    @NotBlank(message = "La marque doit être renseignée")
    public String idBrand;

    public List<ImageDTO> images;
}
