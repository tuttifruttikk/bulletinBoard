package org.suai.laba15;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Announcement {
    private String header;
    private String text;
    private String author;
    private LocalDateTime dateTime;

    private int id;

    private ArrayList<Answer> answers = new ArrayList<>();

    public Announcement(String header, String text, String author, int id) {
        this.header = header;
        this.text = text;
        this.author = author;
        this.dateTime = LocalDateTime.now();
        this.id = id;
    }

    public void setAnswers(Answer answer) {
        answers.add(answer);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

        sb.append("<div class=\"ann\">");
        sb.append("<div class=\"announcement_header\">");
        sb.append("<div class=\"announcement_header_title\">").append(header).append("</div>");
        sb.append("<div class=\"announcement_header_author\">").append(author).append(", ").append(dateTime.format(formatter)).append("</div>");
        sb.append("</div>");
        sb.append("<div class=\"announcement_text\">").append(text).append("</div>");
        sb.append("<div class=\"answer\">");
        sb.append("<a href=\"answer?id=").append(id).append("\"class=\"answer_button\">reply</a>");
        sb.append("</div>");
        sb.append("</div>");
        for (int i = 0; i < answers.size(); ++i) {
            sb.append(answers.get(i));
        }

        return sb.toString();
    }
}
