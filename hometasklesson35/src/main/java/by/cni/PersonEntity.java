package by.cni;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor @Getter
@Setter
@Entity
@Table(name = "persons")
public class PersonEntity {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String name;
    Integer salary;
    @Enumerated(EnumType.STRING)
    Type role;

}
