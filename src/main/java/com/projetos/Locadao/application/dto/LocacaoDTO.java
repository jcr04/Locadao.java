package com.projetos.Locadao.application.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class LocacaoDTO {
    private Long id;
    private Long veiculoId;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private double valorTotal;
}
