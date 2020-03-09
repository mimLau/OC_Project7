package org.mimi.clibrary.Beans.publication;

public class BookBean extends PublicationBean {

    private EditorBean editor;
    private AuthorBean author;

    public EditorBean getEditor() {
        return editor;
    }

    public void setEditor(EditorBean editor) {
        this.editor = editor;
    }

    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }
}
