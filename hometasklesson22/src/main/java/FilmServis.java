import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter @AllArgsConstructor
@Setter 

public class FilmServis {

    private static List<Film> films = new ArrayList<>();
    static {
        films.add(new Film("King Kong", "big animal", 1988,true));
        films.add(new Film("Avatar", "fantasy", 2005,false));
    }
    public void add(Film film){
        films.add(film);
    }

    public List<Film> getAll(){
        return films;
    }

    public Film getById(UUID id){
        Optional<Film> find = films.stream()
                .filter(film -> film.getId().equals(id))
                .findFirst();
        return find.orElseThrow(() -> new RuntimeException("film not found"));
    }
    public void edit(UUID id, Film film){
        for (Film item : films) {
            if (item.getId().equals(id)) {
                item.setName(film.getName());
                item.setDescription(film.getDescription());
                item.setYearOfRelease(film.getYearOfRelease());
                item.setViewed(film.getViewed());

            }
        }
    }

    public void delete(UUID id) {
        Film filmById = getById(id);
        films.remove(filmById);
    }
}
