import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private FilmServis filmServis = new FilmServis();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Film> films = filmServis.getAll();


        req.setAttribute("films", films);
        req.getRequestDispatcher("/films.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        int yearOfRelease = Integer.parseInt(req.getParameter("yearOfRelease"));
        Boolean viewed = Boolean.valueOf((req.getParameter("viewed")));

        Film film = new Film(name, description, yearOfRelease, viewed);
        filmServis.add(film);
        resp.sendRedirect("/home");

    }
}
