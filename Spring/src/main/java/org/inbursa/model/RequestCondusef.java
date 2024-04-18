package org.inbursa.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RequestCondusef {


    private String mensaje;
    private Double env;

}
