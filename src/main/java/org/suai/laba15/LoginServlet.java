package org.suai.laba15;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    private HashMap<String, String> users = null;
    private UserDAO dao = new UserDAO("users.txt");

    @Override
    public void init() throws ServletException {
        users = dao.loadFile();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (password.equals(users.get(login))) {
            HttpSession session = request.getSession();
            session.setAttribute("login", login);
            response.sendRedirect("board");
        } else {
            writer.println(report("Incorrect login or password, please try again."));
        }
    }

    public String report(String cause) {
        return "<!DOCTYPE html>" +
                "<html><head>" +
                "<meta charset=\"UTF-8\">" +
                "<link rel=\"stylesheet\" href=\"../styles/main.css\"/>" +
                "<title>" +
                "Error Page" +
                "</title>" +
                "</head>" +
                "<body>" +
                "<div class=\"error_text\">" +
                "<h1> ERROR </h1>" +
                "<p>" + cause + "</p>" +
                "<a href=\"login.html\" class=\"menu_button\">Login</a>" +
                "</div>" + "</body>" + "</html>";
    }
}
