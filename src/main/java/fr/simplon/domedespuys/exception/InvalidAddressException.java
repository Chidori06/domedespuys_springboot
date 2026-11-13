package fr.simplon.domedespuys.exception;

public class InvalidAddressException extends RuntimeException {

    public InvalidAddressException() {
        super("L'adresse renseignée est invalide");
    }
}
