package fr.simplon.domedespuys.controller.advise;

import fr.simplon.domedespuys.exception.InvalidAddressException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InvalidAddressExceptionResponse {
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidAddressException.class)
    public ExceptionResponse getResponse(InvalidAddressException e){
        return new ExceptionResponse(
                "La requête n'est pas correctement formatée",
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name()
        );
    }

}
