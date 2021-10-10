package com.example.demo.Controller.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class MovieRequest {
    private String idMovie;
    private String name;
    private String urlImage;
    private int year;
    private String type;
    private float score;
    private String status;
}
