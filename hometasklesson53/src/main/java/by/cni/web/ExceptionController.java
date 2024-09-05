package by.cni.web;

import by.cni.dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handlerException(Exception e){
        return ResponseEntity.badRequest().body(new ErrorDto("refused"));
    }
}
