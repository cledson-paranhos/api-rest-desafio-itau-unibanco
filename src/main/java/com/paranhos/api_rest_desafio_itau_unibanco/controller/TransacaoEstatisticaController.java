package com.paranhos.api_rest_desafio_itau_unibanco.controller;

import com.paranhos.api_rest_desafio_itau_unibanco.dto.TransacaoEstatisticaDTO;
import com.paranhos.api_rest_desafio_itau_unibanco.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("estatistica")
public class TransacaoEstatisticaController {
    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public ResponseEntity<TransacaoEstatisticaDTO> obterEstatisticas() {
        DoubleSummaryStatistics doubleSummaryStatistics = transacaoService.obterEstatisticas();

        TransacaoEstatisticaDTO transacaoEstatisticaDTO = new TransacaoEstatisticaDTO();
        transacaoEstatisticaDTO.setCount(doubleSummaryStatistics.getCount());
        transacaoEstatisticaDTO.setSum(doubleSummaryStatistics.getSum());
        transacaoEstatisticaDTO.setAvg(doubleSummaryStatistics.getAverage());
        transacaoEstatisticaDTO.setMin(doubleSummaryStatistics.getMin());
        transacaoEstatisticaDTO.setMax(doubleSummaryStatistics.getMax());

        return ResponseEntity.ok(transacaoEstatisticaDTO);
    }
}
