package dev.tarun.productservice.exceptions;

import dev.tarun.productservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices {
//    //controllerAdvicer will act in between controller and spring dispatcher
//    //if controller is throwing an exception
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException notFoundException){
//
//        return new ResponseEntity<>(
//                new ExceptionDto(HttpStatus.NOT_FOUND,notFoundException.getMessage()),
//                HttpStatus.NOT_FOUND
//        );
//    }
//    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
//    public ResponseEntity<ExceptionDto> handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException notFoundException){
//
//        return new ResponseEntity<>(
//                new ExceptionDto(HttpStatus.NOT_FOUND,notFoundException.getMessage()),
//                HttpStatus.NOT_FOUND
//        );
//    }
//    //for Global Exception Handler you can use Exception.class
}
