package com.example.demo.Repository;

import com.example.demo.Entity.RankBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RankBoardRepository extends JpaRepository<RankBoardEntity,Integer> {
    public List<RankBoardEntity> findAll();
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "Delete from rank_board where id_movie =?1")
    public void deleteByIdMovie(String idMovie);
}
