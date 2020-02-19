package com.mimi.mlibrary.model.works;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Book")
public class Book extends Work {

    private String editor;
    private String publishingDate;
    private String title;
    private String isbn;

    @Enumerated(EnumType.STRING)
    private Category category;


    @ManyToOne
    @JoinColumn(name="author_fk")
    private Author author;

    public Book() {
        super();
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(String publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
