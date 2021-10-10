package com.example.demo.Entity;

import java.io.Serializable;

public class FavouriteListId implements Serializable {
    private String idMovie;
    private String idViewer;

    public FavouriteListId(String idMovie, String idViewer) {
        this.idMovie = idMovie;
        this.idViewer = idViewer;
    }
}
