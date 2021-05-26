package com.polyglot.domain.entities;


import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name = "dictionaries")
public class Dictionary {
    public static final String STATUS_ACTIVE = "ACTIVE";

    @Id
    @GeneratedValue
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    private String name;

    private String description;

    private String status;

    private Integer languageId;

}
