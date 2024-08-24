package by.cni.dto;

import by.cni.domain.TypeOfBike;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
