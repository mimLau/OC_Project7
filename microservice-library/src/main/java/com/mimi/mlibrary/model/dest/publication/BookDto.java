package com.mimi.mlibrary.model.dest.publication;

import com.mimi.mlibrary.model.source.publication.Category;
import com.mimi.mlibrary.model.source.publication.Editor;

public class BookDto extends PublicationDto {

    private Editor editor;

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    };

}
