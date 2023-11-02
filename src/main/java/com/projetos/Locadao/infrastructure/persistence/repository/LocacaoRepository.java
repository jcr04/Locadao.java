package com.projetos.Locadao.infrastructure.persistence.repository;

import com.projetos.Locadao.domain.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

    List<Locacao> findByDataInicioBetween(LocalDate start, LocalDate end);

    @Query("SELECT l FROM Locacao l WHERE l.veiculo.id = :veiculoId")
    List<Locacao> findByVeiculoId(@Param("veiculoId") Long veiculoId);
}
