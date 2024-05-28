import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FilmMapper {

    public Film map(ResultSet rs, boolean needNext) {

        Film film = new Film();

        try {
            if (needNext){
                rs.next();
            }

            UUID id = rs.getObject("id", UUID.class);
            String name = rs.getString("name");
            String description = rs.getString("description");
            int yearOfRelease = rs.getInt("yearOfRelease");
            boolean viewed = rs.getBoolean("viewed");

            film.setId(id);
            film.setName(name);
            film.setDescription(description);
            film.setYearOfRelease(yearOfRelease);
            film.setViewed(viewed);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

         return film;
    }
    @SneakyThrows
    public List<Film> maps(ResultSet rs){
        List<Film> films = new ArrayList<Film>();
        while (rs.next()){
            Film film = map(rs, false);
            if (film != null){
                films.add(film);
            }
        }
        return films;
    }

}
