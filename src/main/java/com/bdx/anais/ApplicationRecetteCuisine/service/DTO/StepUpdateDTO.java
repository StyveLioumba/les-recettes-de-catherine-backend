package com.bdx.anais.ApplicationRecetteCuisine.service.DTO;

import java.util.UUID;

public class StepUpdateDTO {

    private String stepId;
    private String idRecette;
    private Integer num_recette;
    private String description;

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    public String getIdRecette() {
        return idRecette;
    }

    public void setIdRecette(String idRecette) {
        this.idRecette = idRecette;
    }

    public Integer getNum_recette() {
        return num_recette;
    }

    public void setNum_recette(Integer num_recette) {
        this.num_recette = num_recette;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
