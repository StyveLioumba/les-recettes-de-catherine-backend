package com.bdx.anais.ApplicationRecetteCuisine.service.DTO;

public class RecipeUpdateDTO {

    private String idRecipe;
    private String name;
    private String picture;
    private Integer preparationTimeMinutes;
    private Integer cookingTimeMinutes;
    private String tips;
    private String categorieRecette;

    public String getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(String idRecipe) {
        this.idRecipe = idRecipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getPreparationTimeMinutes() {
        return preparationTimeMinutes;
    }

    public void setPreparationTimeMinutes(Integer preparationTimeMinutes) {
        this.preparationTimeMinutes = preparationTimeMinutes;
    }

    public Integer getCookingTimeMinutes() {
        return cookingTimeMinutes;
    }

    public void setCookingTimeMinutes(Integer cookingTimeMinutes) {
        this.cookingTimeMinutes = cookingTimeMinutes;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getCategorieRecette() {
        return categorieRecette;
    }

    public void setCategorieRecette(String categorieRecette) {
        this.categorieRecette = categorieRecette;
    }
}
