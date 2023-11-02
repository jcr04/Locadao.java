package com.projetos.Locadao.application.dto;

import lombok.Data;

@Data
public class VeiculoDTO {
    private Long id;
    private String marca;
    private String modelo;
    private String placa;
    private int ano;
    private double precoDiaria;
}
