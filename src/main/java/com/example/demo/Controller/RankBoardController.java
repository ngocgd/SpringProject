package com.example.demo.Controller;

import com.example.demo.Controller.Request.RankRequest;
import com.example.demo.Entity.RankBoardEntity;
import com.example.demo.Repository.RankBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RankBoardController {
    @Autowired
    RankBoardRepository rankBoardRepository;

    @GetMapping(value = {"/getRank"})
    public List<RankBoardEntity> getRankBoard(){
        return rankBoardRepository.findAll();
    }
}
