import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/del")
public class DeleteServlet extends HttpServlet {

    private FilmServis filmServis = new FilmServis();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("id");
        UUID id = UUID.fromString(uuid);

        filmServis.delete(id);
        resp.sendRedirect("/home");
    }
}
