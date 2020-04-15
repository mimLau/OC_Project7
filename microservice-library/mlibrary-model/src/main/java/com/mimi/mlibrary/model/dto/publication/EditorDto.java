package com.mimi.mlibrary.model.dto.publication;

import com.mimi.mlibrary.model.entity.publication.Publication;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class EditorDto {

    private Integer id;
    private String name;
    private List<Publication> publications;
}
