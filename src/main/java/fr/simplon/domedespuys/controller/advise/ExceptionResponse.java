package fr.simplon.domedespuys.controller.advise;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.ExceptionView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExceptionResponse {

    @JsonView(ExceptionView.Message.class)
    String message;

    @JsonView(ExceptionView.Status.class)
    int status;

    @JsonView(ExceptionView.Name.class)
    String name;

}
