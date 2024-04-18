package org.inbursa.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseCondusef {

    private String env;
    private String mensaje;

    public ResponseCondusef() {

    }
}
