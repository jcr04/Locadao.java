package com.projetos.Locadao.application.services;

import com.projetos.Locadao.domain.model.Locacao;
import com.projetos.Locadao.domain.model.Veiculo;
import com.projetos.Locadao.domain.repository.Locacaorepository;
import com.projetos.Locadao.infrastructure.Exceptions.ResourceNotFoundException;
import com.projetos.Locadao.infrastructure.persistence.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

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
        Veiculo veiculo = veiculoRepository.findById(locacao.getVeiculo().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Veículo não encontrado"));

        long dias = DAYS.between(locacao.getDataInicio(), locacao.getDataFim());
        locacao.setValorTotal(dias * veiculo.getPrecoDiaria());

        return locacaoRepository.save(locacao);
    }


    public void deleteById(Long id) {
        locacaoRepository.deleteById(id);
    }
}
