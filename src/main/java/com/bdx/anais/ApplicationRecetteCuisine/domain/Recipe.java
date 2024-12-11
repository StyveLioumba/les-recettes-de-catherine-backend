package com.bdx.anais.ApplicationRecetteCuisine.domain;

import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.RecipeRecordDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="tab_recipe" , schema = "recipe")

public class Recipe {

    @Id
    @UuidGenerator
    @Column(name="recipe_id")
    private UUID id;

    @Column(name="recipe_name")
    private String name;

    @Column(name="recipe_picture")
    private String picture;

    @Column(name = "recipe_type")
    private TypeRecetteEnum typeRecette;

    @Column(name="recipe_total_time")
    private Integer totalTimeMinutes;

    @Column(name="recipe_prep_time")
    private Integer preparationTimeMinutes;

    @Column(name="recipe_cook_time")
    private Integer cookingTimeMinutes;

    @Column(name="recipe_tips")
    private String tips;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<IngredientRecipe> ingredientRecipe;


    public Recipe(RecipeRecordDTO recipeDTO) {
        this.name = recipeDTO.getName();
        this.picture = recipeDTO.getPicture();
        this.totalTimeMinutes = recipeDTO.getPreparationTimeMinutes() + recipeDTO.getCookingTimeMinutes();
        this.preparationTimeMinutes = recipeDTO.getPreparationTimeMinutes();
        this.cookingTimeMinutes = recipeDTO.getCookingTimeMinutes();
        this.tips = recipeDTO.getTips();
        this.typeRecette = recipeDTO.getTypeRecette();
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Integer getTotalTimeMinutes() {
        return totalTimeMinutes;
    }

    public void setTotalTimeMinutes(Integer totalTimeMinutes) {
        this.totalTimeMinutes = totalTimeMinutes;
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

    public Set<IngredientRecipe> getIngredientRecipe() {
        return ingredientRecipe;
    }

    public void setIngredientRecipe(Set<IngredientRecipe> ingredientRecipe) {
        this.ingredientRecipe = ingredientRecipe;
    }

    public TypeRecetteEnum getTyperecette() {
        return typerecette;
    }

    public void setTyperecette(TypeRecetteEnum typerecette) {
        this.typerecette = typerecette;
    }
}
