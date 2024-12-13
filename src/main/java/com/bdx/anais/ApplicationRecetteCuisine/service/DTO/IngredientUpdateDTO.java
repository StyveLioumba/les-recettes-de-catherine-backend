package com.bdx.anais.ApplicationRecetteCuisine.service.DTO;

public class IngredientUpdateDTO {

    private String idIngredient;
    private String ingName;

    public IngredientUpdateDTO() {
    }

    public IngredientUpdateDTO(String ingName, String idIngredient) {
        this.ingName = ingName;
        this.idIngredient = idIngredient;
    }

    public String getIngName() {
        return ingName;
    }

    public void setIngName(String ingName) {
        this.ingName = ingName;
    }

    public String getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(String idIngredient) {
        this.idIngredient = idIngredient;
    }
}
