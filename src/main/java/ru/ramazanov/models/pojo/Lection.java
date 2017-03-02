package ru.ramazanov.models.pojo;

/**
 * Created by admin on 24.02.2017.
 */
public class Lection {
    private int id;
    private String  title;
    private String  text;
    private String  subject;

    public Lection() {
    }

    public Lection(int id, String title, String text, String subject) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
