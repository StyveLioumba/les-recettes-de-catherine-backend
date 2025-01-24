package com.bdx.anais.ApplicationRecetteCuisine.service.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StepRecordDTO {

    private Integer numero_etape;
    private String idRecette;
    private String description;

}
