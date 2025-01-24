package com.bdx.anais.ApplicationRecetteCuisine.shared.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse <T>{
    private String status;
    private int code;
    private String message = "no message";
    private T content = null;
    private MetaData meta = null;
}
