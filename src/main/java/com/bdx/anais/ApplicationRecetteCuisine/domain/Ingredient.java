package com.bdx.anais.ApplicationRecetteCuisine.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ths_ingredient", schema = "recipe")
public class Ingredient {

    @Column(name = "ing_id")
    @Id
    @UuidGenerator
    private UUID idIngredient;

    @Getter
    @Setter
    @Column(name = "ing_name")
    private String name;

    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<IngredientRecipe> ingredientRecipe = new ArrayList<>();

    public Ingredient(String name) {
        this.name = name;
    }
}
