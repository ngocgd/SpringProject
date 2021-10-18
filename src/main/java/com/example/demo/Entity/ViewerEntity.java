package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "viewer")
public class ViewerEntity {
    @Id
    @Column(name = "id_viewer")
    private String idViewer;
    @Column(name = "userName")
    private String userName;
    @Column(name ="pass_word")
    private String passWord;
    @Column(name = "email")
    private String emai;


}
