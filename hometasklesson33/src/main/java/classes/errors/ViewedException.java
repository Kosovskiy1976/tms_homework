package classes.errors;

import lombok.Data;

@Data
public class ViewedException extends RuntimeException{

    public ViewedException(String message){
        super(message);
    }
}
