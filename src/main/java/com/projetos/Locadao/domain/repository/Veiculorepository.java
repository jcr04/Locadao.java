package com.projetos.Locadao.domain.repository;

import com.projetos.Locadao.domain.model.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class Veiculorepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Veiculo> findAll() {
        try {
            return entityManager.createQuery("from Veiculo", Veiculo.class).getResultList();
        } catch (DataAccessException e) {
            throw new RuntimeException("Erro ao buscar todos os veículos", e);
        }
    }

    public Optional<Veiculo> findById(Long id) {
        try {
            return Optional.ofNullable(entityManager.find(Veiculo.class, id));
        } catch (DataAccessException e) {
            throw new RuntimeException("Erro ao buscar veículo pelo ID", e);
        }
    }

    public Veiculo save(Veiculo veiculo) {
        try {
            entityManager.persist(veiculo);
            return veiculo;
        } catch (DataAccessException e) {
            throw new RuntimeException("Erro ao salvar veículo", e);
        }
    }

    @Transactional
    public void deleteById(Long id) {
        findById(id).ifPresent(veiculo -> {
            try {
                entityManager.remove(veiculo);
            } catch (DataAccessException e) {
                throw new RuntimeException("Erro ao remover veículo pelo ID", e);
            }
        });
    }
}
