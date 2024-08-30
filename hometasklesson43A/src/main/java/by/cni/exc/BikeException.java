package by.cni.exc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class BikeException extends RuntimeException {

    private Integer code;
    private String message;
}
