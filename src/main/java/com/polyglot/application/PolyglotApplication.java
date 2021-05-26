package com.polyglot.application;

import com.polyglot.domain.constants.AssertErrors;
import com.polyglot.domain.dto.LanguageDictionariesDTO;
import com.polyglot.domain.entities.Dictionary;
import com.polyglot.domain.entities.Language;
import com.polyglot.repository.DictionaryRepository;
import com.polyglot.repository.LanguageRepository;
import com.polyglot.services.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PolyglotApplication {

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired private DictionaryRepository dictionaryRepository;

    @Autowired Asserts asserts;

    public List<LanguageDictionariesDTO> getDictionariesByLanguageId(Integer languageId){

        List<Language> languages = new ArrayList<>();
        List<LanguageDictionariesDTO> languageDictionariesDTOList = new ArrayList<>();

        if(languageId != null){
            Language language = this.languageRepository.findOneById(languageId);
            this.asserts.resourceExists(language, AssertErrors.LANGUAGE_NOT_FOUND);
            languages.add(language);

        }else {
            languages = languageRepository.findByStatus(Language.STATUS_ACTIVE);
        }

        for(Language language : languages){
            LanguageDictionariesDTO dto = new LanguageDictionariesDTO();
            dto.setLanguage(language.getLanguage());
            dto.setId(language.getId());
            dto.setDictionaries(this.dictionaryRepository.findByLanguageIdAndStatus(language.getId(), Dictionary.STATUS_ACTIVE).stream().map(Dictionary::getName).collect(Collectors.toList()));
            languageDictionariesDTOList.add(dto);
        }
        return languageDictionariesDTOList;
    }

}
