package fr.simplon.domedespuys.dto;

import fr.simplon.domedespuys.entity.Image;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class ProductDTO {

    @NotBlank(message = "Le nom du produit doit être renseigné")
    public String label;

    public String description;

    @NotBlank(message = "Le prix doit être renseigné")
    public int price;

    @NotBlank(message = "La marque doit être renseignée")
    public String idBrand;

    public List<ImageDTO> images;
}
