package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rank_board")
public class RankBoardEntity {
    @Id
    @Column(name = "STT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stt;

    @Column(name = "view")
    private float view;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_movie",referencedColumnName = "id_movie")
    @JsonBackReference
    private MovieEntity movieEntity;
}
