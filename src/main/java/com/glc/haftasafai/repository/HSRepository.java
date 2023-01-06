package com.glc.haftasafai.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.glc.haftasafai.entities.Volunteers;

@Repository
public interface HSRepository extends CrudRepository<Volunteers, Long> {
    
    Volunteers findByEmail(String email);

}
