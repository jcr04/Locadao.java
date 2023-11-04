package com.projetos.Locadao.infrastructure.Exceptions;


public class VeiculoNaoEncontradoException extends RuntimeException {
    public VeiculoNaoEncontradoException(String message) {
        super(message);
    }
}