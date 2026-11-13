package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class UserPostDTO {

    @NotBlank(message = "L'email doit être renseignée")
    public String email;

    @NotBlank(message = "Le mot de passe doit être renseigné")
    public String password;

    @NotBlank(message = "Le nom de famille doit être renseigné")
    public String lastname;

    @NotBlank(message = "Le prénom doit être renseigné")
    public String firstname;

}
