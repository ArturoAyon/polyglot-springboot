package com.polyglot.controllers;

import com.polyglot.application.PolyglotApplication;
import com.polyglot.domain.dto.LanguageDictionariesDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/polyglot")
public class PolyglotController {
    @Autowired private PolyglotApplication polyglotApplication;

    @ApiOperation(
            value = "Get dictionaries by language id",
            consumes = "application/json",
            produces = "application/json",
            nickname = "getDictionariesByLanguage",
            response = LanguageDictionariesDTO.class,
            tags = {"Dictionaries, Languages, Get"})
    @GetMapping(value = "/dictionaries")
    public List<LanguageDictionariesDTO> getDictionariesByLanguage(@RequestParam(value = "languageId", required = false) Integer languageId){
        return this.polyglotApplication.getDictionariesByLanguageId(languageId);
    }


}
