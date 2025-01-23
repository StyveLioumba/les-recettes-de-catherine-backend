package com.bdx.anais.ApplicationRecetteCuisine.service.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RecipeUpdateDTO {

    private String idRecipe;
    private String name;
    private String picture;
    private Integer preparationTimeMinutes;
    private Integer cookingTimeMinutes;
    private String tips;
    private String categorieRecette;

}
