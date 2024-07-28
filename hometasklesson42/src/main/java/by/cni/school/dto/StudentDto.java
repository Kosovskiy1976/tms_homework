package by.cni.school.dto;

import by.cni.school.domain.Sex;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    UUID id;
    String name;
    String surname;
    String sex;
    Integer yearofbirth;
    Integer classnumber;
    String adress;
}
