package com.polyglot.repository;

import com.polyglot.domain.entities.Dictionary;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DictionaryRepository extends CrudRepository<Dictionary, Integer> {

    List<Dictionary> findByLanguageIdAndStatus(Integer languageId, String status);
}
