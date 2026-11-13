package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.NotBlank;

public class AddressDTO {

    @NotBlank(message = "L'adresse doit être renseignée")
    public String line;

    public String extraLine;

    @NotBlank(message = "La ville doit être renseignée")
    public String city;

    @NotBlank(message = "Le code postal doit être renseigné")
    public String zipCode;

    @NotBlank(message = "Le pays doit être renseigné")
    public String country;

    public String phone;

    @NotBlank(message = "Le prénom doit être renseigné")
    public String firstname;

    @NotBlank(message = "Le nom de famille doit être renseigné")
    public String lastname;
}
