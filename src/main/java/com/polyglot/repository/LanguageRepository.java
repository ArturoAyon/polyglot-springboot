package com.polyglot.repository;

import com.polyglot.domain.entities.Language;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LanguageRepository extends CrudRepository<Language, Integer> {

    List<Language> findByStatus(String status);

    Language findOneById(Integer id);
}
