package com.projetos.Locadao.infrastructure.persistence.repository;

import com.projetos.Locadao.domain.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    @Query("SELECT v FROM Veiculo v WHERE v.id = :id AND v.cliente.id = :clienteId")
    Optional<Veiculo> findByIdAndClienteId(@Param("id") Long id, @Param("clienteId") Long clienteId);

    @Query("SELECT CASE WHEN COUNT(v) > 0 THEN TRUE ELSE FALSE END FROM Veiculo v WHERE v.id = :id AND v.cliente.id = :clienteId")
    boolean existsByIdAndClienteId(@Param("id") Long id, @Param("clienteId") Long clienteId);

    @Override
    Veiculo save(Veiculo veiculo);

    List<Veiculo> findByMarca(String marca);

    @Query("SELECT v FROM Veiculo v WHERE v.precoDiaria <= :precoMax")
    List<Veiculo> findByPrecoDiariaMenorQue(@Param("precoMax") double precoMax);
}
