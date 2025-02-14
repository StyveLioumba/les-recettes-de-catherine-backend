package com.bdx.anais.ApplicationRecetteCuisine.service.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StepUpdateDTO {

    private String idRecette;
    private Integer numStep;
    private String description;
}
