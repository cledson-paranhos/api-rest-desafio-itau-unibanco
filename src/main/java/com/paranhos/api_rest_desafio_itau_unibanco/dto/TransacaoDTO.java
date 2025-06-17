package com.paranhos.api_rest_desafio_itau_unibanco.dto;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class TransacaoDTO {
    private Double valor;
    private OffsetDateTime  dataHora;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public OffsetDateTime  getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
