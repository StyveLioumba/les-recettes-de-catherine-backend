package com.bdx.anais.ApplicationRecetteCuisine.domain;


import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.IngredientRecordDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
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

    @Column(name = "ing_name")
    private String name;

    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<IngredientRecipe> ingredientRecipe;

    public Ingredient(IngredientRecordDTO ingredientDTO) {
        this.name = ingredientDTO.getNomIngredient();
    }

    public Ingredient(String name) {
        this.name = name;
    }

    public UUID getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(UUID idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
