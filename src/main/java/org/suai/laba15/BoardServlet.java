package org.suai.laba15;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "board", value = "/board")
public class BoardServlet extends HttpServlet {
    private ArrayList<Announcement> announcementsList = new ArrayList<>();

    private static int GLOBAL_ID = 0;

    public ArrayList<Announcement> getAnnouncementsList() {
        return announcementsList;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        PrintWriter writer = response.getWriter();
        RequestDispatcher requestDispatcher;
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        request.getRequestDispatcher("header.html").include(request, response);
        if (session != null) {
            requestDispatcher = request.getRequestDispatcher("header_for_users.html");
        } else {
            requestDispatcher = request.getRequestDispatcher("header_for_guests.html");
        }
        requestDispatcher.include(request, response);

        writer.println("<body>");
        writer.println("<div class=\"board\">");

        for (int i = 0; i < announcementsList.size(); ++i) {
            writer.println(announcementsList.get(i));
        }


        writer.println("</div>");
        writer.println("</html></body>");

        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);

        String header = request.getParameter("header");
        String text = request.getParameter("text");

        String text_answer = request.getParameter("text_answer");
        String idS = request.getParameter("id");

        if (session != null) {
            Announcement announcement;
            Answer answer;
            if (text_answer == null) {
                announcement = new Announcement(header, text, (String) session.getAttribute("login"), GLOBAL_ID);
                announcementsList.add(announcement);
                GLOBAL_ID++;
                response.sendRedirect("board");
            } else {
                int id = Integer.parseInt(idS);
                answer = new Answer((String) session.getAttribute("login"), text_answer, id);
                announcement = announcementsList.get(id);
                announcement.setAnswers(answer);
                announcementsList.set(id, announcement);
                response.sendRedirect("board");
            }

        }
    }

    public String report(String cause) {
        return "<!DOCTYPE html>" +
                "<html><head>" +
                "<meta charset=\"UTF-8\">" +
                "<title>" +
                "Error Page" +
                "</title>" +
                "</head>" +
                "<body>" +
                "<div class=\"error_text\">" +
                "<p> ERROR </p>" +
                "<p>" + cause + "</p>" +
                "</div>" + "</body>" + "</html>";
    }
}
