package com.projetos.Locadao.ui.web.controller;

import com.projetos.Locadao.application.services.CsvExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/export")
public class CsvExportController {

    @Autowired
    private CsvExportService csvExportService;

    @GetMapping("/clientes.csv")
    public ResponseEntity<String> exportClientesToCsv() {
        String csvContent = csvExportService.exportClientesToCsv();
        return prepareResponse(csvContent, "clientes.csv");
    }

    @GetMapping("/locacoes.csv")
    public ResponseEntity<String> exportLocacoesToCsv() {
        String csvContent = csvExportService.exportLocacoesToCsv();
        return prepareResponse(csvContent, "locacoes.csv");
    }

    @GetMapping("/veiculos.csv")
    public ResponseEntity<String> exportVeiculosToCsv() {
        String csvContent = csvExportService.exportVeiculosToCsv();
        return prepareResponse(csvContent, "veiculos.csv");
    }

    private ResponseEntity<String> prepareResponse(String csvContent, String filename) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);
        headers.add(HttpHeaders.CONTENT_TYPE, "text/csv; charset=UTF-8");
        return ResponseEntity.ok().headers(headers).body(csvContent);
    }
}
