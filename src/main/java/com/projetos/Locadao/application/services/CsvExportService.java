package com.projetos.Locadao.application.services;

import com.projetos.Locadao.infrastructure.persistence.repository.ClienteRepository;
import com.projetos.Locadao.infrastructure.persistence.repository.LocacaoRepository;
import com.projetos.Locadao.infrastructure.persistence.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opencsv.CSVWriter;
import java.io.StringWriter;
import java.util.List;
import com.projetos.Locadao.domain.model.Cliente;
import com.projetos.Locadao.domain.model.Locacao;
import com.projetos.Locadao.domain.model.Veiculo;

@Service
public class CsvExportService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private LocacaoRepository locacaoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public String exportClientesToCsv() {
        List<Cliente> clientes = clienteRepository.findAll();
        StringWriter stringWriter = new StringWriter();
        CSVWriter csvWriter = new CSVWriter(stringWriter);
        csvWriter.writeNext(new String[]{"ID", "Nome", "CPF", "Data de Nascimento", "Endereço", "Idade", "CNH"});
        for (Cliente cliente : clientes) {
            csvWriter.writeNext(new String[]{
                    cliente.getId().toString(),
                    cliente.getNome(),
                    cliente.getCpf(),
                    cliente.getDataNascimento() != null ? cliente.getDataNascimento().toString() : "",
                    cliente.getEndereco() != null ? cliente.getEndereco() : "",
                    cliente.getIdade() != null ? cliente.getIdade().toString() : "",
                    String.valueOf(cliente.isCnh())}
            );
        }
        return stringWriter.toString();
    }

    public String exportLocacoesToCsv() {
        List<Locacao> locacoes = locacaoRepository.findAll();
        StringWriter stringWriter = new StringWriter();
        CSVWriter csvWriter = new CSVWriter(stringWriter);
        csvWriter.writeNext(new String[]{"ID", "Veiculo ID", "Data Inicio", "Data Fim", "Valor Total"});
        for (Locacao locacao : locacoes) {
            csvWriter.writeNext(new String[]{
                    locacao.getId() != null ? locacao.getId().toString() : "",
                    locacao.getVeiculo() != null && locacao.getVeiculo().getId() != null ? locacao.getVeiculo().getId().toString() : "",
                    locacao.getDataInicio() != null ? locacao.getDataInicio().toString() : "",
                    locacao.getDataFim() != null ? locacao.getDataFim().toString() : "",
                    Double.toString(locacao.getValorTotal())
            });
        }
        return stringWriter.toString();
    }

    public String exportVeiculosToCsv() {
        List<Veiculo> veiculos = veiculoRepository.findAll();
        StringWriter stringWriter = new StringWriter();
        CSVWriter csvWriter = new CSVWriter(stringWriter);
        csvWriter.writeNext(new String[]{"ID", "Marca", "Modelo", "Placa", "Ano", "Preco Diaria", "Alugado"});
        for (Veiculo veiculo : veiculos) {
            csvWriter.writeNext(new String[]{
                    veiculo.getId() != null ? veiculo.getId().toString() : "",
                    veiculo.getMarca() != null ? veiculo.getMarca() : "",
                    veiculo.getModelo() != null ? veiculo.getModelo() : "",
                    veiculo.getPlaca() != null ? veiculo.getPlaca() : "",
                    Integer.toString(veiculo.getAno()),
                    Double.toString(veiculo.getPrecoDiaria()),
                    veiculo.isAlugado() != null ? veiculo.isAlugado().toString() : ""
            });
        }
        return stringWriter.toString();
    }
}



