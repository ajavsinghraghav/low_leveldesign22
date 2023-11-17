package dev.tarun.productservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND) //another way to handle exception instead of using controllerAdvicer
public class NotFoundException extends Exception{
    public NotFoundException(String message){

        super(message);
    }
}
