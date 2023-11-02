package com.projetos.Locadao.application.services;

import com.projetos.Locadao.domain.model.Locacao;
import com.projetos.Locadao.domain.repository.Locacaorepository;
import com.projetos.Locadao.infrastructure.persistence.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LocacaoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private Locacaorepository locacaoRepository;

    public List<Locacao> findAll() {
        return locacaoRepository.findAll();
    }

    public Optional<Locacao> findById(Long id) {
        return locacaoRepository.findById(id);
    }

    @Transactional
    public Locacao save(Locacao locacao) {
        return locacaoRepository.save(locacao);
    }

    public void deleteById(Long id) {
        locacaoRepository.deleteById(id);
    }
}
