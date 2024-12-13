package com.bdx.anais.ApplicationRecetteCuisine.repository;

import com.bdx.anais.ApplicationRecetteCuisine.domain.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StepRepo extends JpaRepository<Step, UUID> {


//    @Query(value = "SELECT MAX(step_num) FROM recipe.step s where s.recipe_id = recette",
//            nativeQuery = true)
//    Integer findMaxVisitId(@Param("recette") String recette);
//
//    @Query(value = "SELECT count(step_num) FROM recipe.step s where s.recipe_id = recette",
//            nativeQuery = true)
//    Integer countStep();
}