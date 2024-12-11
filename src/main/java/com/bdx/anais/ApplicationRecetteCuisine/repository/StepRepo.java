package com.bdx.anais.ApplicationRecetteCuisine.repository;

import com.bdx.anais.ApplicationRecetteCuisine.domain.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StepRepo extends JpaRepository<Step, UUID> {

}