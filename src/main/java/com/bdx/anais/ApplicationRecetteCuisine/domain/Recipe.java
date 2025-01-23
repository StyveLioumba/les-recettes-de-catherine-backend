package com.bdx.anais.ApplicationRecetteCuisine.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tab_recipe", schema = "recipe")
public class Recipe {

    @Id
    @UuidGenerator
    @Column(name = "recipe_id")
    private UUID id;

    @Column(name = "recipe_name")
    private String name;

    @Column(name = "recipe_picture")
    private String picture;

    @Column(name = "recipe_type")
    private CategorieRecetteEnum categorieRecetteEnum;

    @Column(name = "recipe_total_time")
    private Integer totalTimeMinutes;

    @Column(name = "recipe_prep_time")
    private Integer preparationTimeMinutes;

    @Column(name = "recipe_cook_time")
    private Integer cookingTimeMinutes;

    @Column(name = "recipe_tips")
    private String tips;

    @OneToMany(mappedBy = "recipe")
    private List<IngredientRecipe> ingredientRecipe = new ArrayList<>();

    @OneToMany(mappedBy = "recipe")
    private List<Step> steps = new ArrayList<>();
}
