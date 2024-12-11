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


    public IngredientRecipe() {
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public EnumUnity getUnity() {
        return unity;
    }

    public void setUnity(EnumUnity unity) {
        this.unity = unity;
    }
}

