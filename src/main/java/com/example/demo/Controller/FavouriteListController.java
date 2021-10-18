package com.example.demo.Controller;

import com.example.demo.Entity.FavouriteListEntity;
import com.example.demo.Repository.FavouriteListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FavouriteListController {
    @Autowired
    FavouriteListRepository favouriteListRepository;
    @GetMapping(value = {"/getFavouriteList"})
    public List<FavouriteListEntity> findFavouriteList(){
        return favouriteListRepository.findAll();
    }
    // ----------EmbeddedId Annotation
//    @GetMapping(value = {"/getFavouriteList2"})
//    public List<Object> findFavourite2(){
//        return favouriteListRepository.findAll2();
//    }

}
