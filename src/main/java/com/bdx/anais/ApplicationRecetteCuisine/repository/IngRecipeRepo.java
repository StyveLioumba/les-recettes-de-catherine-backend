package com.bdx.anais.ApplicationRecetteCuisine.repository;

import com.bdx.anais.ApplicationRecetteCuisine.domain.IngredientRecipe;
import com.bdx.anais.ApplicationRecetteCuisine.domain.IngredientRecipeId;
import com.bdx.anais.ApplicationRecetteCuisine.domain.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IngRecipeRepo extends JpaRepository<IngredientRecipe, IngredientRecipeId> {

}