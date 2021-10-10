package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavouriteList {
    private String id_viewer;
    private String id_movie;

    public String getId_viewer() {
        return id_viewer;
    }

    public String getId_movie() {
        return id_movie;
    }
}
