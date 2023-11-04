package com.projetos.Locadao.application.services;

import com.projetos.Locadao.domain.model.Cliente;
import com.projetos.Locadao.domain.model.Veiculo;
import com.projetos.Locadao.domain.repository.Veiculorepository;
import com.projetos.Locadao.infrastructure.Exceptions.ClienteNaoEncontradoException;
import com.projetos.Locadao.infrastructure.Exceptions.NegocioException;
import com.projetos.Locadao.infrastructure.Exceptions.VeiculoAlugadoException;
import com.projetos.Locadao.infrastructure.Exceptions.VeiculoNaoEncontradoException;
import com.projetos.Locadao.infrastructure.persistence.repository.ClienteRepository;
import com.projetos.Locadao.infrastructure.persistence.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;


@Service
public class VeiculoService {

    @Autowired
    private Veiculorepository veiculoRepository;
    @Autowired
    private VeiculoRepository VeiculoRepository;

    private ClienteRepository clienteRepository;
    private static final Logger logger = LoggerFactory.getLogger(VeiculoService.class);

    @Autowired
    public void ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public boolean isVeiculoAlugado(Long veiculoId) {
        return VeiculoRepository.existsByIdAndClienteId(veiculoId, null);
    }

    @Transactional
    public Veiculo alugarVeiculo(Long veiculoId, Long clienteId) {
        logger.info("Alugando veiculo {} para cliente {}", veiculoId, clienteId);
        Veiculo veiculo = buscarVeiculo(veiculoId);
        Cliente cliente = buscarCliente(clienteId);

        // Verificando se o cliente tem CNH e é maior de 18 anos
        if (!cliente.isCnh()) {
            throw new NegocioException("Cliente não possui CNH");
        }
        if (cliente.getIdade() < 18) {
            throw new NegocioException("Cliente é menor de 18 anos");
        }

        if (veiculo.isAlugado()) {
            throw new VeiculoAlugadoException("Veículo já está alugado");
        }

        veiculo.setCliente(cliente);
        veiculo.setAlugado(true);

        Veiculo veiculoSalvo = veiculoRepository.save(veiculo);
        logger.info("Veículo {} alugado com sucesso para cliente {}", veiculoId, clienteId);
        return veiculoSalvo;
    }

    private Veiculo buscarVeiculo(Long veiculoId) {
        return veiculoRepository.findById(veiculoId)
                .orElseThrow(() -> new VeiculoNaoEncontradoException("Veículo não encontrado"));
    }

    private Cliente buscarCliente(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado"));
    }


    @Transactional
    public Veiculo save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        veiculoRepository.deleteById(id);
    }
}
