package com.hoaxify.ws.shared;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // Constructor yazmadığında controllerda setMessage yapmak gerekiyor kod uzuyor
public class GenericResponse {
    private String message;
}
