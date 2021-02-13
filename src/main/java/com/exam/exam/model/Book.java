package com.exam.exam.model;

public class Book {
    private long id;
    private String title;
    private String author;
    private String publisher;
    private int publishingYear;

    public Book() {
    }

    public Book(long id, String title, String author, String publisher, int publishingYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
    }

    public Book(String title, String author, String publisher, int publishingYear) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publisherYear) {
        this.publishingYear = publisherYear;
    }
}
