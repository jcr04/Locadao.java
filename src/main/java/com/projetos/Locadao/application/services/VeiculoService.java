package com.projetos.Locadao.application.services;

import com.projetos.Locadao.domain.model.Veiculo;
import com.projetos.Locadao.domain.repository.Veiculorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private Veiculorepository veiculoRepository;

    @Transactional
    public Veiculo save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> findById(Long id) {
        return veiculoRepository.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        veiculoRepository.deleteById(id);
    }
}
