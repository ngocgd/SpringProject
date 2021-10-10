package com.example.demo.Repository;


import com.example.demo.Entity.MovieEntity;
import com.example.demo.Model.Movie;
import org.hibernate.query.NativeQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.lang.annotation.Native;
import java.util.Collection;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity,String> {
    List<MovieEntity> findAll();
    List<MovieEntity> findByYearIn(Collection collection, Pageable pageable);
    @Query(value = "select u from MovieEntity u where year=?1")
    List<MovieEntity> findByAndSort(Integer year,Sort sort);
    Page<MovieEntity> findByYear(Integer year, Pageable pageable);
    MovieEntity findByIdMovie(String IdMovie);
    @Transactional
    @Modifying  // Transactional : rollback if error , Modifying : notification udpate
    @Query(nativeQuery = true,value = "Update movie set year=?1 where id_movie=?2 ")
    int updateYearMovieByIdMovie(Integer year,String idMovie);
}
