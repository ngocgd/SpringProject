package com.example.demo.Controller;

import com.example.demo.Entity.ViewerEntity;
import com.example.demo.Model.Viewer;
import com.example.demo.Repository.ViewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ViewerController {
    @Autowired
    ViewerRepository viewerRepository;
    @GetMapping(value = {"/getAllViewer"})
    public List<ViewerEntity> findAllViewer(){
        return viewerRepository.findAll();
    }
}
