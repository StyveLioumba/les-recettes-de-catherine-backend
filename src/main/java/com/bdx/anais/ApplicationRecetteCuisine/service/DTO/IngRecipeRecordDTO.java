package com.bdx.anais.ApplicationRecetteCuisine.service.DTO;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IngRecipeRecordDTO {

    private String idRecipe;
    private String idIngredient;
    private Long quantity;
    private String unity;

}
