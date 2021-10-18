package com.example.demo.Repository;

import com.example.demo.Entity.FavouriteListEntity;
import com.example.demo.Entity.FavouriteListId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteListRepository extends JpaRepository<FavouriteListEntity, FavouriteListId> {
    List<FavouriteListEntity> findAll();
//    @Query(value = "select t.favouriteListId.idViewer from FavouriteListEntity t")  //Use EmbeddableId Annotation
//    public List<Object> findAll2();
}
