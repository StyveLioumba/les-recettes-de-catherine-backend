package com.bdx.anais.ApplicationRecetteCuisine.service.DTO;

import com.bdx.anais.ApplicationRecetteCuisine.domain.CategorieRecetteEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RecipeRecordDTO {

    private String name;
    private String picture;
    private Integer preparationTimeMinutes;
    private Integer cookingTimeMinutes;
    private String tips;
    private CategorieRecetteEnum categorieRecetteEnum;
}
