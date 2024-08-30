package by.cni.web.exc;

import by.cni.dto.ErrorDto;
import by.cni.esc.CommonServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(CommonServiceException.class)
    public ResponseEntity<ErrorDto> handlerServiceException(CommonServiceException e){
        ErrorDto errorDto = new ErrorDto(e.getCode(), e.getMessage());
        return ResponseEntity.badRequest().body(errorDto);
    }
}
