package org.suai.laba15;

public class Answer {
    private String name;
    private String text;
    private int id;

    public Answer(String name, String text, int id) {
        this.name = name;
        this.text = text;
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<div class=\"answer_block\">");
        sb.append("<div class=\"answer_name\">");
        sb.append(name);
        sb.append("</div>");
        sb.append("<div class=\"answer_text\">");
        sb.append(text);
        sb.append("</div>");
        sb.append("</div>");

        return sb.toString();
    }
}
