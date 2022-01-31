package org.suai.laba15;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "answer", value = "/answer")
public class AnswerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        String id = request.getParameter("id");

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\"/>");
        writer.println("<title>New Answer</title>");
        writer.println("<link rel=\"stylesheet\" href=\"../styles/main.css\"/>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<div class=\"header\">");
        writer.println("<div class=\"header_name\">New Answer</div>");
        writer.println("<form action=\"board\" method=\"post\" class=\"form_new-answer\">");
        writer.println("<div class=\"form_text\">");
        writer.println("<label class=\"label\">Answer<br>");
        writer.println("<textarea type=\"text\" name=\"text_answer\" class=\"input\" placeholder=\"Enter the answer\" required></textarea>");
        writer.println("</label>");
        writer.println("</div>");
        writer.println("<input type=\"hidden\" name=\"id\" value=\"" + id + "\"/>");
        writer.println("<div class=\"form_submit\">");
        writer.println("<input type=\"submit\" value=\"Create new answer\" name=\"" + id + "\" class=\"menu_button-ann\"/>");
        writer.println("</div>");
        writer.println("</form>");
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
