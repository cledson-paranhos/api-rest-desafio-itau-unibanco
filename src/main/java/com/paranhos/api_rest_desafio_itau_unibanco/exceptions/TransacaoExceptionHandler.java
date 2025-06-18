package com.paranhos.api_rest_desafio_itau_unibanco.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TransacaoExceptionHandler {

    @ExceptionHandler(TransacaoException.class)
    public ResponseEntity<Void> handleTransacaoException(TransacaoException transacaoException) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }

}
