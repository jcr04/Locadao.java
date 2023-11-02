package com.projetos.Locadao.application.services;

import com.projetos.Locadao.domain.model.Locacao;
import com.projetos.Locadao.domain.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository locacaoRepository;

    public List<Locacao> findAll() {
        return locacaoRepository.findAll();
    }

    public Locacao findById(Long id) {
        return locacaoRepository.findById(id);
    }

    public Locacao save(Locacao locacao) {
        return locacaoRepository.save(locacao);
    }

    public void deleteById(Long id) {
        locacaoRepository.deleteById(id);
    }
}
