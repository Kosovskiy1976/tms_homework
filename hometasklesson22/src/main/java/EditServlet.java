import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private FilmServis filmServis = new FilmServis();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        UUID uuid = UUID.fromString(id);
        Film film = filmServis.getById(uuid);
        req.setAttribute("film", film);
        req.getRequestDispatcher("/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        int yearOfRelease = Integer.parseInt(req.getParameter("yearOfRelease"));
        Boolean viewed = Boolean.valueOf((req.getParameter("viewed")));
        String uuid = req.getParameter("id");
        UUID id = UUID.fromString(uuid);

        Film film = new Film(name, description, yearOfRelease, viewed);

        filmServis.edit(id, film);
        resp.sendRedirect("/home");


    }

}
