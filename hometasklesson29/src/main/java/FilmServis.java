import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter @AllArgsConstructor
@Setter

public class FilmServis {

//    private static List<Film> films = new ArrayList<>();
    private final FilmMapper filmMapper = new FilmMapper();
//    static {
//        films.add(new Film("King Kong", "big animal", 1988,true));
//        films.add(new Film("Avatar", "fantasy", 2005,false));
//    }
    public void add(Film film){

        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into films (name, description, yearOfRelease, viewed, id) values (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, film.getName());
            preparedStatement.setString(2, film.getDescription());
            preparedStatement.setInt(3, film.getYearOfRelease());
            preparedStatement.setBoolean(4, film.getViewed());
            preparedStatement.setObject(5, film.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Film> getAll(){
       try(Connection connection = getConnection()) {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("select * from films");
           return filmMapper.maps(resultSet);

       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }

    public Film getById(UUID id){
        try(Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from films where id = ?");
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Film film = filmMapper.map(resultSet, true);
            return film;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void edit(UUID id, Film film){
        String name = film.getName();
        try(Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("update films set name = ?, description = ?, yearOfRelease = ?, viewed = ? where id = ?");
            preparedStatement.setString(1, film.getName());
            preparedStatement.setString(2, film.getDescription());
            preparedStatement.setInt(3, film.getYearOfRelease());
            preparedStatement.setBoolean(4, film.getViewed());
            preparedStatement.setObject(5, id);

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(UUID id) {
          try(Connection connection = getConnection()) {
              PreparedStatement preparedStatement = connection.prepareStatement("delete from films where id = ?");
              preparedStatement.setObject(1, id);
              preparedStatement.execute();
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
//        Film filmById = getById(id);
//        films.remove(filmById);
    }

    private Connection getConnection(){
        try {
            return DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres?user=postgres&password=Ichbin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
