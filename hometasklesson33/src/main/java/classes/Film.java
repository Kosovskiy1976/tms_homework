package classes;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class Film {

    private String name;
    @Length(min = 3, message = "description wrong")
    private String description;
    @Min(value = 1800, message = "year incorrect")
    private Integer yearOfRelease;
    private Boolean viewed;
    private UUID id;

    public Film(String name, String description, Integer yearOfRelease, Boolean viewed) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.yearOfRelease = yearOfRelease;
        this.viewed = viewed;
    }
}
