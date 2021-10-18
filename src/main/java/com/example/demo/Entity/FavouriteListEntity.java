package com.example.demo.Entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "favourite_list")
@IdClass(FavouriteListId.class)
public class FavouriteListEntity {
    @Id
    @Column(name = "id_viewer")
    private String idViewer;

    @Id
    @Column(name = "id_movie")
    private String idMovie;
}
