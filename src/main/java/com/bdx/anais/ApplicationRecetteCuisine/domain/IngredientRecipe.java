package com.bdx.anais.ApplicationRecetteCuisine.domain;
import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.IngRecipeRecordDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rel_ing_recipe" , schema = "recipe")
@IdClass(IngredientRecipeId.class)
public class IngredientRecipe {

    @Id
    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    @Id
    @ManyToOne
    @JoinColumn(name = "ing_id", nullable = false)
    private Ingredient ingredient;

    @Column(name="ing_quantity")
    private Long quantity;

    @Column(name="ing_unity")
    private EnumUnity unity;


    public IngredientRecipe(IngRecipeRecordDTO ingRecipeRecordDTO) {
        this.quantity= ingRecipeRecordDTO.getQuantity();
        this.unity =ingRecipeRecordDTO.getUnity();
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}

