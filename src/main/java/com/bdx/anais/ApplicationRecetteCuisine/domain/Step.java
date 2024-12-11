package com.bdx.anais.ApplicationRecetteCuisine.domain;

import com.bdx.anais.ApplicationRecetteCuisine.service.DTO.StepRecordDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tab_step" , schema = "recipe")

public class Step {

    @Id
    @Column(name = "step_id")
    @UuidGenerator
    private UUID stepId;

    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    @Column(name = "step_num")
    private Integer numStep;

    @Column(name = "step_description")
    private String description;

    public Step(StepRecordDTO stepDTO) {
        this.numStep = stepDTO.getNum_recette();
        this.description = stepDTO.getDescription();
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Integer getNumStep() {
        return numStep;
    }

    public void setNumStep(Integer numStep) {
        this.numStep = numStep;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
