package com.bdx.anais.ApplicationRecetteCuisine.repository;

import com.bdx.anais.ApplicationRecetteCuisine.domain.Ingredient;
import com.bdx.anais.ApplicationRecetteCuisine.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, UUID> {

}