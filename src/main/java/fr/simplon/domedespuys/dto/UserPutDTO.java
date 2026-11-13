package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.NotBlank;

public class UserPutDTO {

    @NotBlank(message = "Le nom de famille doit être renseigné")
    public String lastname;

    @NotBlank(message = "Le prénom doit être renseigné")
    public String firstname;

    public String phone;
}
