package com.bdx.anais.ApplicationRecetteCuisine.service.DTO;

import com.bdx.anais.ApplicationRecetteCuisine.domain.EnumUnity;

public class IngRecipeRecordDTO {

    private String idRecipe;
    private String idIngredient;
    private Long quantity;
    private String unity;

    public String getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(String idRecipe) {
        this.idRecipe = idRecipe;
    }

    public String getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(String idIngredient) {
        this.idIngredient = idIngredient;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }
}
