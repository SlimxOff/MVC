package org.example.model;

public class Post {
    private long id;
    private String content;

    // Конструктор по умолчанию
    public Post() {
    }

    // Конструктор с параметрами
    public Post(long id, String content) {
        this.id = id;
        this.content = content;
    }

    // Геттеры и сеттеры
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}