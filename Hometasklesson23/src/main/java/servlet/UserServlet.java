package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lang = req.getParameter("lang");
        String inf = req.getParameter("inf");

        PrintWriter writer = resp.getWriter();
        writer.println("Name is " + name);
        writer.println("Lang is " + lang);
        writer.println("Add information is " + inf);

    }
}
