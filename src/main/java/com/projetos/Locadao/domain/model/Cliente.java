package com.projetos.Locadao.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String endereco;
    private Integer idade;
    private Boolean cnh = false;

    @OneToMany(mappedBy = "cliente")
    private List<Veiculo> veiculos = new ArrayList<>();

    public Cliente(Long id) {
        this.id = id;
    }

    // Método para calcular a idade baseada na data de nascimento
    public void calcularIdade() {
        LocalDate hoje = LocalDate.now();
        this.idade = hoje.getYear() - this.dataNascimento.getYear();
        if (hoje.getDayOfYear() < this.dataNascimento.getDayOfYear()) {
            this.idade--;
        }
        atualizarCnh();  // Atualizar o valor de cnh após calcular a idade
    }

    // Novo método para atualizar o valor de cnh baseado na idade
    public void atualizarCnh() {
        this.cnh = this.idade >= 18;
    }

    public boolean isCnh() {
        return cnh != null && cnh;
    }


}
