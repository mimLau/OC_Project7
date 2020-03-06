package com.mimi.mlibrary.model.dto.publication;

import com.mimi.mlibrary.model.entity.publication.Editor;

public class BookDto extends PublicationDto {

    private Editor editor;

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    };

}
