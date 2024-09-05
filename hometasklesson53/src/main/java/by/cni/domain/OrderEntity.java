package by.cni.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    private int numberOfPhone;
    private int idOfCinema;
    private int idOfSession;
    private int idOfPlace;
    private Status status;

}
