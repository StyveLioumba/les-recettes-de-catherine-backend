package com.bdx.anais.ApplicationRecetteCuisine.service.DTO;

import java.util.UUID;

public class StepRecordDTO {

    private Integer numero_etape;
    private String idRecette ;
    private String description;

    public String getIdRecette() {
        return idRecette;
    }

    public void setIdRecette(String idRecette) {
        this.idRecette = idRecette;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumero_etape() {
        return numero_etape;
    }

    public void setNumero_etape(Integer numero_etape) {
        this.numero_etape = numero_etape;
    }
}
