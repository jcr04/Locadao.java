package com.projetos.Locadao.domain.model;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    private LocalDate dataInicio;
    private LocalDate dataFim;
    private double valorTotal;

    // Outros métodos e lógica de negócios relacionados a locações podem ser adicionados aqui
}
