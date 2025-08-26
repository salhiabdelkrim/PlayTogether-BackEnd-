package com.example.PlayTogether.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PlayTogether.model.Encounter;

public interface EncounterRepository extends JpaRepository<Encounter, Long> {   
}
