package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode
public class FavouriteListId implements Serializable {
    private String idViewer;
    private String idMovie;
}
