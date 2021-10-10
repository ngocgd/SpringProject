package com.example.demo.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
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
