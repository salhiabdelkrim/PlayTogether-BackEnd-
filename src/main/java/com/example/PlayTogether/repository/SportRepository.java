package com.example.PlayTogether.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PlayTogether.model.Sport;

public interface SportRepository extends JpaRepository<Sport, Long> {
    
    
}
