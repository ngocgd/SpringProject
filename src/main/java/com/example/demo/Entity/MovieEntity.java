package com.example.demo.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Getter
@Setter
@Entity
@Table(name = "movie")
public class MovieEntity {
    @Id
    @Column(name = "Id_movie")
    private String idMovie;

    @Column(name = "name")
    private String name;

    @Column(name = "url_image")
    private String urlImage;

    @Column(name = "year")
    private Integer year;

    @Column(name = "type")
    private String type;

    @Column(name ="score")
    private float score;

    @Column(name = "status")
    private String status;


}
