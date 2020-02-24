package com.mimi.mlibrary.model.dest.publication;

import com.mimi.mlibrary.model.dest.publication.PublicationDto;
import com.mimi.mlibrary.model.source.publication.Category;

public class BookDto extends PublicationDto {

    private String editor;
    private String publishingDate;
    private String title;
    private String isbn;
    private Category category;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
