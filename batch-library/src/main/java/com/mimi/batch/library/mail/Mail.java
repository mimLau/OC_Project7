package com.mimi.batch.library.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mail {

    private String from;
    private String to;
    private String subject;
    private String content;
    private List<Object> attachments;
    private Map<String, Object> model;

}
