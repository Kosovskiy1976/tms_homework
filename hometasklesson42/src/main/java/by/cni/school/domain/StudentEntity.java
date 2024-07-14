package by.cni.school.domain;

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
@Table(name = "students")
public class StudentEntity {
    @Id @UuidGenerator
    UUID id;
    String name;
    String surname;
    @Enumerated(EnumType.STRING)
    Sex sex;
    Integer yearofbirth;
    Integer classnumber;
    String adress;

}

