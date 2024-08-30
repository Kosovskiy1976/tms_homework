package by.cni.esc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CommonServiceException extends RuntimeException {

    private Integer code;
    private String message;

}
