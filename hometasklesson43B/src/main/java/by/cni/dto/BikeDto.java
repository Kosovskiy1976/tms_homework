package by.cni.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class BikeDto {

    @NotNull
    private UUID id;

    @Size(min = 2, max = 50)
    private String manufacturer;

    private TypeOfBike type;

    private Boolean rented;
}
