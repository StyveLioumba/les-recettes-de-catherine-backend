package com.bdx.anais.ApplicationRecetteCuisine.shared.model;

import com.bdx.anais.ApplicationRecetteCuisine.domain.EnumUnity;
import com.bdx.anais.ApplicationRecetteCuisine.domain.Ingredient;

public record IngredientRecipeResponse(Ingredient ingredient, Long quantity, EnumUnity unity) {
}
