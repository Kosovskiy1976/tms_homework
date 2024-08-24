package by.cni.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class BikeDto {

    private UUID id;

    private String manufacturer;

    private TypeOfBike type;

    private Boolean rented;
}
