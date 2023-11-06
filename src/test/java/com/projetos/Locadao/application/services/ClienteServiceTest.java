package com.projetos.Locadao.application.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.projetos.Locadao.domain.model.Cliente;
import com.projetos.Locadao.infrastructure.persistence.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    public void whenSavingCliente_thenClienteIsSavedCorrectly() {
        // Arrange
        Cliente testCliente = createTestCliente();
        testCliente.calcularIdade();

        when(clienteRepository.save(any(Cliente.class))).thenReturn(testCliente);

        // Act
        Cliente savedCliente = clienteService.save(testCliente);

        // Assert
        assertClienteIsSavedCorrectly(testCliente, savedCliente);
    }

    private Cliente createTestCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Teste");
        cliente.setCpf("12345678909");
        cliente.setDataNascimento(LocalDate.of(2000, 1, 1));
        cliente.setEndereco("Rua Teste, 123");
        return cliente;
    }

    private void assertClienteIsSavedCorrectly(Cliente expected, Cliente actual) {
        assertNotNull(actual);
        assertEquals(expected.getIdade(), actual.getIdade());
        assertTrue(actual.isCnh());
        verify(clienteRepository).save(expected);
    }

    // Outros testes ...
}
