package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RankBoard {
    private int STT;
    private float view;
    private String id_movie;

    public int getSTT() {
        return STT;
    }

    public float getView() {
        return view;
    }

    public String getId_movie() {
        return id_movie;
    }
}