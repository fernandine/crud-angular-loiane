package com.github.com.crudjean.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
//@Table(name = "cursos")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;
    @Column(name = "nome", length = 200, nullable = false)
    private String name;
    @Column(name = "categoria", length = 10, nullable = false)
    private String category;
}
