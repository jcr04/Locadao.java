package com.projetos.Locadao.domain.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private String placa;
    private int ano;
    private double precoDiaria;

    // Outros métodos e lógica de negócios relacionados a veículos podem ser adicionados aqui
}
