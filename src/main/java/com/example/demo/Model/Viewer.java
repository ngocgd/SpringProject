package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Viewer {
    private String id_viewer;
    private String user_name;
    private String pass_word;
    private String email;

    public String getId_viewer() {
        return id_viewer;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPass_word() {
        return pass_word;
    }

    public String getEmail() {
        return email;
    }
}
