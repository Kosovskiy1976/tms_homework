package by.cni.web.exc;

import by.cni.dto.ErrorDto;
import by.cni.exc.BikeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(BikeException.class)
    public ResponseEntity<ErrorDto> handleBikeException(BikeException e){
        ErrorDto errorDto = new ErrorDto(e.getCode(), e.getMessage());
        return ResponseEntity.badRequest().body(errorDto);
    }
}
