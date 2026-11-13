package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.NotBlank;

public class ImageDTO {

    @NotBlank(message = "Le lien de l'image doit être renseigné")
    public String path;

    @NotBlank(message = "L'image par défaut doit être désignée")
    public boolean isDefault;

}
