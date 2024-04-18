package org.inbursa.model;


import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder
public class ResponseGeneral {

    private String env;
    private String mensaje;
    private Object objeto;
    private Double version;
}
