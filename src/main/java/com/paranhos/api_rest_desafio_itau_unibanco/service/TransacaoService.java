package com.paranhos.api_rest_desafio_itau_unibanco.service;

import com.paranhos.api_rest_desafio_itau_unibanco.entities.Transacao;
import com.paranhos.api_rest_desafio_itau_unibanco.exceptions.TransacaoException;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class TransacaoService {
    private List<Transacao> listTransacao = new ArrayList<>();

    public void salvarTransacao(Transacao transacao) {
        if (transacao.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new TransacaoException("Data não pode ser no futuro.");
        }

        if (transacao.getValor() < 0) {
            throw new TransacaoException("Valor não pode ser negativo.");
        }

        listTransacao.add(transacao);
    }

    public void deletarTransacao() {
        listTransacao.clear();
    }

    public DoubleSummaryStatistics obterEstatisticas() {
        OffsetDateTime umMin = OffsetDateTime.now().minusMinutes(1);

        return listTransacao.stream().filter(e -> e.getDataHora().isBefore(umMin))
                .mapToDouble(Transacao::getValor).summaryStatistics();
    }
}
