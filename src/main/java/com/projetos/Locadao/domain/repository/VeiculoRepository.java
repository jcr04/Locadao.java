package com.projetos.Locadao.domain.repository;

import com.projetos.Locadao.domain.model.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class VeiculoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Veiculo> findAll() {
        return entityManager.createQuery("from Veiculo", Veiculo.class).getResultList();
    }

    public Veiculo findById(Long id) {
        return entityManager.find(Veiculo.class, id);
    }

    public Veiculo save(Veiculo veiculo) {
        entityManager.persist(veiculo);
        return veiculo;
    }

    public void deleteById(Long id) {
        Veiculo veiculo = findById(id);
        if (veiculo != null) {
            entityManager.remove(veiculo);
        }
    }
}
