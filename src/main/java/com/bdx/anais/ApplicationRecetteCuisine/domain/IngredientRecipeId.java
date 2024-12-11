package com.bdx.anais.ApplicationRecetteCuisine.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class IngredientRecipeId implements Serializable {

    private Recipe recipe ;
    private Ingredient ingredient;

    public IngredientRecipeId(Recipe recipe, Ingredient ingredient) {
        this.recipe = recipe;
        this.ingredient = ingredient;
    }

}
