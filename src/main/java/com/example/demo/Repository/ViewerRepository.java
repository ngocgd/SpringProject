package com.example.demo.Repository;

import com.example.demo.Entity.ViewerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewerRepository extends JpaRepository<ViewerEntity,String> {
    public List<ViewerEntity> findAll();
}
