package com.bdx.anais.ApplicationRecetteCuisine.repository;

import com.bdx.anais.ApplicationRecetteCuisine.domain.IngredientRecipe;
import com.bdx.anais.ApplicationRecetteCuisine.domain.IngredientRecipeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IngRecipeRepo extends JpaRepository<IngredientRecipe, IngredientRecipeId> {

    @Query("FROM IngredientRecipe i WHERE i.recipe.id = :RecipeId")
    Optional<List<IngredientRecipe>> findIngredientRecipeBy(UUID RecipeId);
}