package com.paranhos.api_rest_desafio_itau_unibanco.controller;

import com.paranhos.api_rest_desafio_itau_unibanco.dto.TransacaoEstatisticaDTO;
import com.paranhos.api_rest_desafio_itau_unibanco.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estatistica")
public class TransacaoEstatisticaController {
    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public ResponseEntity<TransacaoEstatisticaDTO> obterEstatisticas() {
        TransacaoEstatisticaDTO transacaoEstatisticaDTO = transacaoService.obterEstatisticas();
        return ResponseEntity.ok(transacaoEstatisticaDTO);
    }
}
