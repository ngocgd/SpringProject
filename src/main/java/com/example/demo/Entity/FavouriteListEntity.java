package com.example.demo.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@IdClass(FavouriteListId.class)
@Table(name = "favourite_list")
public class FavouriteListEntity {
    @Id
    @Column(name = "id_viewer")
    private String idViewer;
    @ManyToOne
    private ViewerEntity viewerEntity;

    @Id
    @Column(name = "id_movie")
    private String idMovie;
    @ManyToOne
    private MovieEntity movieEntity;
}
