package com.projetos.Locadao.controller;

import com.projetos.Locadao.application.services.ClienteService;
import com.projetos.Locadao.domain.model.Cliente;
import com.projetos.Locadao.ui.web.controller.ClienteController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ClienteControllerTest {

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenCreateCliente_thenReturnsSavedCliente() {
        Cliente cliente = new Cliente();
        when(clienteService.save(any(Cliente.class))).thenReturn(cliente);

        ResponseEntity<Cliente> response = clienteController.create(new Cliente());

        assertNotNull(response.getBody());
        assertEquals(response.getStatusCodeValue(), 200);
        verify(clienteService, times(1)).save(any(Cliente.class));
    }

    @Test
    void whenGetAllClientes_thenReturnsClienteList() {
        List<Cliente> clienteList = List.of(new Cliente(), new Cliente());
        when(clienteService.findAll()).thenReturn(clienteList);

        ResponseEntity<List<Cliente>> response = clienteController.getAll();

        assertNotNull(response.getBody());
        assertEquals(response.getStatusCodeValue(), 200);
        assertEquals(2, response.getBody().size());
        verify(clienteService, times(1)).findAll();
    }

    @Test
    void whenGetClienteById_thenReturnsCliente() {
        Cliente cliente = new Cliente();
        when(clienteService.findById(anyLong())).thenReturn(Optional.of(cliente));

        ResponseEntity<Cliente> response = clienteController.getById(1L);

        assertTrue(response.getBody() != null);
        assertEquals(response.getStatusCodeValue(), 200);
        verify(clienteService, times(1)).findById(anyLong());
    }

    @Test
    void whenGetClienteById_thenReturnsNotFound() {
        when(clienteService.findById(anyLong())).thenReturn(Optional.empty());

        ResponseEntity<Cliente> response = clienteController.getById(1L);

        assertFalse(response.hasBody());
        assertEquals(response.getStatusCodeValue(), 404);
        verify(clienteService, times(1)).findById(anyLong());
    }

    @Test
    void whenUpdateCliente_thenReturnsUpdatedCliente() {
        Cliente existingCliente = new Cliente();
        when(clienteService.findById(anyLong())).thenReturn(Optional.of(existingCliente));
        when(clienteService.save(any(Cliente.class))).thenReturn(existingCliente);

        ResponseEntity<Cliente> response = clienteController.update(1L, new Cliente());

        assertNotNull(response.getBody());
        assertEquals(response.getStatusCodeValue(), 200);
        verify(clienteService, times(1)).save(any(Cliente.class));
    }

    @Test
    void whenUpdateCliente_thenReturnsNotFound() {
        when(clienteService.findById(anyLong())).thenReturn(Optional.empty());

        ResponseEntity<Cliente> response = clienteController.update(1L, new Cliente());

        assertFalse(response.hasBody());
        assertEquals(response.getStatusCodeValue(), 404);
        verify(clienteService, times(1)).findById(anyLong());
    }

    @Test
    void whenDeleteCliente_thenReturnsNoContent() {
        when(clienteService.findById(anyLong())).thenReturn(Optional.of(new Cliente()));

        ResponseEntity<Void> response = clienteController.delete(1L);

        assertEquals(response.getStatusCodeValue(), 204);
        verify(clienteService, times(1)).deleteById(anyLong());
    }

    @Test
    void whenDeleteCliente_thenReturnsNotFound() {
        when(clienteService.findById(anyLong())).thenReturn(Optional.empty());

        ResponseEntity<Void> response = clienteController.delete(1L);

        assertEquals(response.getStatusCodeValue(), 404);
        verify(clienteService, times(1)).findById(anyLong());
    }


}

