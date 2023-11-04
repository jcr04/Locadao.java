package com.projetos.Locadao.infrastructure.persistence.repository;

import com.projetos.Locadao.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNomeContaining(String nome);

    List<Cliente> findByCpf(String cpf);
}