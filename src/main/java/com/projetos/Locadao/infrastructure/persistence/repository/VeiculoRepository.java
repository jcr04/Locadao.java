package com.projetos.Locadao.infrastructure.persistence.repository;

import com.projetos.Locadao.domain.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByMarca(String marca);

    @Query("SELECT v FROM Veiculo v WHERE v.precoDiaria <= :precoMax")
    List<Veiculo> findByPrecoDiariaMenorQue(@Param("precoMax") double precoMax);
}
