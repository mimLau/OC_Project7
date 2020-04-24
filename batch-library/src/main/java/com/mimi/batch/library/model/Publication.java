package com.mimi.batch.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public  class Publication {

    private String title;
    private List<Copy> copies;
    private String identificationNb;
}
