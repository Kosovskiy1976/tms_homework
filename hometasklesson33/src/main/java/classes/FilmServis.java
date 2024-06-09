package classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
@Setter
@Service
public class FilmServis {
    private final List<Film> films;

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
