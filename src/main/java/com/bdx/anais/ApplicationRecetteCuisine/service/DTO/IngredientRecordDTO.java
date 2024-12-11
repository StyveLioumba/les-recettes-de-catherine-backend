package com.bdx.anais.ApplicationRecetteCuisine.service.DTO;

public class IngredientRecordDTO {

    private String nomIngredient;

    public IngredientRecordDTO(String nomIngredient) {
        this.nomIngredient = nomIngredient;
    }

    public IngredientRecordDTO() {
    }

    public String getNomIngredient() {
        return nomIngredient;
    }
    public void setNomIngredient(String nomIngredient) {
        this.nomIngredient = nomIngredient;
    }
}
