package com.exam.exam.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class BookDTO {
    @NotBlank
    @Size(max = 350)
    private String title;
    @NotBlank
    @Size(max = 350)
    private String author;
    @NotBlank
    @Size(max = 250)
    private String publisher;
    private int publishingYear;

    public BookDTO() {
    }

    public BookDTO(@NotBlank @Size(max = 350) String title, @NotBlank @Size(max = 350) String author, @NotBlank @Size(max = 250) String publisher, int publishingYear) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
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
