package com.bdx.anais.ApplicationRecetteCuisine.service.DTO;

public class StepUpdateDTO {

    private String stepId;
    private String idRecette;
    private Integer num_etape;
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

    public Integer getNum_etape() {
        return num_etape;
    }

    public void setNum_etape(Integer num_etape) {
        this.num_etape = num_etape;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
