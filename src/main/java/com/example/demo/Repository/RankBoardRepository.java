package com.example.demo.Repository;

import com.example.demo.Entity.RankBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankBoardRepository extends JpaRepository<RankBoardEntity,Integer> {
    public List<RankBoardEntity> findAll();
}