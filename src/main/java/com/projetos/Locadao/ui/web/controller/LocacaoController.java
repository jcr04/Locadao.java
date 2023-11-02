package com.projetos.Locadao.ui.web.controller;

import com.projetos.Locadao.application.dto.LocacaoDTO;
import com.projetos.Locadao.application.services.LocacaoService;
import com.projetos.Locadao.domain.model.Locacao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {

    @Autowired
    private LocacaoService locacaoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<LocacaoDTO> listar() {
        return locacaoService.findAll()
                .stream()
                .map(locacao -> modelMapper.map(locacao, LocacaoDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{locacaoId}")
    public LocacaoDTO buscar(@PathVariable Long locacaoId) {
        return modelMapper.map(locacaoService.findById(locacaoId), LocacaoDTO.class);
    }

    @PostMapping
    public LocacaoDTO adicionar(@RequestBody LocacaoDTO locacaoDTO) {
        return modelMapper.map(locacaoService.save(modelMapper.map(locacaoDTO, Locacao.class)), LocacaoDTO.class);
    }

    @DeleteMapping("/{locacaoId}")
    public void remover(@PathVariable Long locacaoId) {
        locacaoService.deleteById(locacaoId);
    }
}
