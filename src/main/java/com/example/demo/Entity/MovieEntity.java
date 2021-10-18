package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movie")
public class MovieEntity {
    @Id
    @Column(name = "id_movie")
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

    @OneToMany(mappedBy = "movieEntity") // cascade = CascadeType.ALL : Auto save to "rankBoard" after update "movie"
    @JsonManagedReference
    private List<RankBoardEntity> rankBoardEntities;


}
