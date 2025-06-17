package com.paranhos.api_rest_desafio_itau_unibanco.controller;

import com.paranhos.api_rest_desafio_itau_unibanco.dto.TransacaoDTO;
import com.paranhos.api_rest_desafio_itau_unibanco.entities.Transacao;
import com.paranhos.api_rest_desafio_itau_unibanco.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public void salvarTransacao(@RequestBody TransacaoDTO transacaoDTO) {
        transacaoService.salvarTransacao(new Transacao(transacaoDTO.getValor(), transacaoDTO.getDataHora()));
    }
}
