package com.paranhos.api_rest_desafio_itau_unibanco.service;

import com.paranhos.api_rest_desafio_itau_unibanco.entities.Transacao;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {
    private List<Transacao> listTransacao = new ArrayList<>();

    public void salvarTransacao(Transacao transacao) {
        listTransacao.add(transacao);
    }

}
