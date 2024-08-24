package by.cni.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bicycles")
public class BikeEntity {

    @Id
    @UuidGenerator
    private UUID id;

    private String manufacturer;

    @Enumerated(EnumType.STRING)
    private TypeOfBike type;

    private Boolean rented;
}
