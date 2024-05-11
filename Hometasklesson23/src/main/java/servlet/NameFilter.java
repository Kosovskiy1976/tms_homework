package servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/name")
public class NameFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String user = request.getParameter("user");

        if (user != null && user.length() >= 5) {
            chain.doFilter(request, response);
        } else request.getRequestDispatcher("/my").forward(request, response);
    }
}
