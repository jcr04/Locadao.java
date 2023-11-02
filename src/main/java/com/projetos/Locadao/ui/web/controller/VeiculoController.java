package com.projetos.Locadao.ui.web.controller;

import com.projetos.Locadao.application.dto.VeiculoDTO;
import com.projetos.Locadao.application.services.VeiculoService;
import com.projetos.Locadao.domain.model.Veiculo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<VeiculoDTO> listar() {
        return veiculoService.findAll()
                .stream()
                .map(veiculo -> modelMapper.map(veiculo, VeiculoDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{veiculoId}")
    public VeiculoDTO buscar(@PathVariable Long veiculoId) {
        return modelMapper.map(veiculoService.findById(veiculoId), VeiculoDTO.class);
    }

    @PostMapping
    public VeiculoDTO adicionar(@RequestBody VeiculoDTO veiculoDTO) {
        return modelMapper.map(veiculoService.save(modelMapper.map(veiculoDTO, Veiculo.class)), VeiculoDTO.class);
    }

    @DeleteMapping("/{veiculoId}")
    public void remover(@PathVariable Long veiculoId) {
        veiculoService.deleteById(veiculoId);
    }
}