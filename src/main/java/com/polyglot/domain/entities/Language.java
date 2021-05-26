package com.polyglot.domain.entities;


import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name = "languages")
public class Language {

    public static final String STATUS_ACTIVE = "ACTIVE";


    @Id
    @GeneratedValue
    @GenericGenerator(name = "increment", strategy = "increment")

    private Integer id;

    private String language;

    private String status;
}
