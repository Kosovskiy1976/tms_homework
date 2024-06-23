import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @AllArgsConstructor
@Setter @NoArgsConstructor

public class Film {
   private String name;
   private String description;
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
