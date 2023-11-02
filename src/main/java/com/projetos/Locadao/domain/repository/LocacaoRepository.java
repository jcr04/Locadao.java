package com.projetos.Locadao.domain.repository;

import com.projetos.Locadao.domain.model.Locacao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class LocacaoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Locacao> findAll() {
        return entityManager.createQuery("from Locacao", Locacao.class).getResultList();
    }

    public Locacao findById(Long id) {
        return entityManager.find(Locacao.class, id);
    }

    public Locacao save(Locacao locacao) {
        entityManager.persist(locacao);
        return locacao;
    }

    public void deleteById(Long id) {
        Locacao locacao = findById(id);
        if (locacao != null) {
            entityManager.remove(locacao);
        }
    }
}
