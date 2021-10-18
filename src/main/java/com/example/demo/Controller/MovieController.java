package com.example.demo.Controller;

import com.example.demo.Controller.Request.MovieRequest;
import com.example.demo.Entity.MovieEntity;
import com.example.demo.Entity.RankBoardEntity;
import com.example.demo.Repository.MovieRepository;
import com.example.demo.Repository.RankBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    RankBoardRepository rankBoardRepository;
    @GetMapping(value = {"/findAll"})
    public List<MovieEntity> findAll(){
        return movieRepository.findAll();
    }
    @GetMapping(value = {"/findByYearIn/{year}"})
    public List<MovieEntity> findAllByYearIn(@PathVariable(name = "year") List<Integer> year){
        Sort sort = Sort.by(Sort.Direction.ASC,"idMovie");
        PageRequest pageRequest = PageRequest.of(1,2,sort);
        List<MovieEntity> movieEntities = movieRepository.findByYearIn(year,pageRequest);
        return movieEntities;
    }

    @GetMapping(value = {"/findByIdMovie/{idMovie}"})
    public MovieEntity findByIdMovie(@PathVariable(name = "idMovie") String idMovie){
        return movieRepository.findByIdMovie(idMovie);
    }
    //find sort ,JPASort.unsafe
    @GetMapping(value = {"/findByYearSort/{year}"})
    public List<MovieEntity> findByYearSort(@PathVariable(name = "year")Integer year){
        return movieRepository.findByAndSort(year, JpaSort.unsafe(Sort.Direction.DESC,"LENGTH(idMovie)")); // 	Valid Sort containing explicitly unsafe Order
    }
    //Paging
    @GetMapping(value = {"/findByYearPaging/{year}"})
    public Page<MovieEntity> findByYearPaging(@PathVariable(name = "year")Integer year,
                                              @RequestParam(name = "page") Integer page,
                                              @RequestParam(name = "size") Integer size,
                                              @RequestParam(name = "sortBy")String sortBy,
                                              @RequestParam(name = "orderBy")String orderBy){
        Sort sort = Sort.by(Sort.Direction.ASC,sortBy);
        if(orderBy.equals("DESC"))
            sort = Sort.by(Sort.Direction.DESC,sortBy);
        PageRequest pageRequest = PageRequest.of(page,size,sort);
        Page<MovieEntity> movieEntities = movieRepository.findByYear(year,pageRequest);
        return movieEntities;

    }
    //update and put

    @PostMapping(value = {"/addMovie"}) // update with association one to many
    public int addMovie(@RequestBody MovieEntity movieEntityRequest ){
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setIdMovie(movieEntityRequest.getIdMovie());
        movieEntity.setName(movieEntityRequest.getName());
        movieEntity.setUrlImage(movieEntityRequest.getUrlImage());
        movieEntity.setYear(movieEntityRequest.getYear());
        movieEntity.setType(movieEntityRequest.getType());
        movieEntity.setScore(movieEntityRequest.getScore());
        movieEntity.setStatus(movieEntityRequest.getStatus());
        movieEntity.setRankBoardEntities(movieEntityRequest.getRankBoardEntities());
        rankBoardRepository.saveAll(movieEntityRequest.getRankBoardEntities());  //save to rankBoard table
        movieRepository.save(movieEntity);
        return 1;
    }
    //NativeQuery
    @PostMapping(value = {"/udpateMovie2/{idMovie}/{year}"})
    public int updateMovieNativeQuery(@PathVariable(name = "idMovie") String idMovie,
                                      @PathVariable(name = "year")Integer year){
        return movieRepository.updateYearMovieByIdMovie(year,idMovie);
    }
    @PutMapping(value={"/updateMovieById"})
    public String updateMovieById(@RequestBody MovieRequest movieRequest){
        if(movieRepository.findByIdMovie(movieRequest.getIdMovie()) == null){
            System.out.println("Movie is not exists");
            return  null;
        }
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setIdMovie(movieRequest.getIdMovie());
        movieEntity.setName(movieRequest.getName());
        movieEntity.setUrlImage(movieRequest.getUrlImage());
        movieEntity.setYear(movieRequest.getYear());
        movieEntity.setType(movieRequest.getType());
        movieEntity.setScore(movieRequest.getScore());
        movieEntity.setStatus(movieRequest.getStatus());
        movieEntity = movieRepository.save(movieEntity);
        return "update completed";
    }
    //delete
    @DeleteMapping(value = {"/deleteMovieById/{idMovie}"})
    public void deleteMovie(@PathVariable(name = "idMovie") String idMovie){
        if(movieRepository.findByIdMovie(idMovie).equals(null)){
            System.out.println("movie is not exists");
        }
        rankBoardRepository.deleteByIdMovie(idMovie);
        movieRepository.deleteById(idMovie);
    }
}
