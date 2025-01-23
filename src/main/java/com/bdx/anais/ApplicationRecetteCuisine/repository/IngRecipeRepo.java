package com.bdx.anais.ApplicationRecetteCuisine.repository;

import com.bdx.anais.ApplicationRecetteCuisine.domain.IngredientRecipe;
import com.bdx.anais.ApplicationRecetteCuisine.domain.IngredientRecipeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngRecipeRepo extends JpaRepository<IngredientRecipe, IngredientRecipeId> {

}