package by.cni.dto;

import by.cni.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private int numberOfPhone;
    private int idOfCinema;
    private int idOfSession;
    private int idOfPlace;
    private Status status;
}
