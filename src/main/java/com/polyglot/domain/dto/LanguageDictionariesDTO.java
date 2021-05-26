package com.polyglot.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class LanguageDictionariesDTO {

    private String language;

    private Integer id;

    List<String> dictionaries;
}
