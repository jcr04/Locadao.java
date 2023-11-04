package com.projetos.Locadao.infrastructure.Exceptions;

import java.io.Serial;

public class NegocioException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public NegocioException(String message) {
        super(message);
    }

    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }
}
