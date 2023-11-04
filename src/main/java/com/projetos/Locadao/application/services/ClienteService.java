package com.projetos.Locadao.application.services;

import com.projetos.Locadao.domain.model.Cliente;
import com.projetos.Locadao.infrastructure.persistence.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente save(Cliente clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setDataNascimento(clienteDTO.getDataNascimento());
        cliente.setEndereco(clienteDTO.getEndereco());
        cliente.calcularIdade();  // Calculando a idade e atualizando o valor de cnh
        return clienteRepository.save(cliente);
    }


    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        // Lógica de negócios antes de buscar um cliente pelo ID
        return clienteRepository.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> findByName(String nome) {
        // Lógica de negócios antes de buscar clientes pelo nome
        return clienteRepository.findByNomeContaining(nome);
    }

    public Cliente findByCpf(String cpf) {
        // Lógica de negócios antes de buscar um cliente pelo CPF
        return clienteRepository.findByCpf(cpf).stream().findFirst().orElse(null);
    }

    // ... Outros métodos conforme necessário
}
