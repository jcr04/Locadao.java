package com.projetos.Locadao.domain.repository;

import com.projetos.Locadao.domain.model.Locacao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class Locacaorepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Locacao> findAll() {
        try {
            return entityManager.createQuery("from Locacao", Locacao.class).getResultList();
        } catch (DataAccessException e) {
            throw new RuntimeException("Erro ao buscar todas as locações", e);
        }
    }

    public Optional<Locacao> findById(Long id) {
        try {
            return Optional.ofNullable(entityManager.find(Locacao.class, id));
        } catch (DataAccessException e) {
            throw new RuntimeException("Erro ao buscar locação pelo ID", e);
        }
    }

    public Locacao save(Locacao locacao) {
        try {
            entityManager.persist(locacao);
            return locacao;
        } catch (DataAccessException e) {
            throw new RuntimeException("Erro ao salvar locação", e);
        }
    }

    public void deleteById(Long id) {
        findById(id).ifPresent(locacao -> {
            try {
                entityManager.remove(locacao);
            } catch (DataAccessException e) {
                throw new RuntimeException("Erro ao remover locação pelo ID", e);
            }
        });
    }
}
