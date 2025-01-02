package com.example.sunbridgejava.ExceptionHandler;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Classe de manipulação global de exceções para a aplicação.
 * 
 * Utiliza a anotação {@link ControllerAdvice} para interceptar e tratar exceções lançadas
 * pelos controladores REST de forma centralizada.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Trata exceções relacionadas ao acesso a dados, como erros SQL.
     *
     * Este método captura todas as exceções que são subclasses de {@link DataAccessException}
     * e retorna uma resposta HTTP apropriada com uma mensagem de erro personalizada.
     *
     * @param ex A exceção de acesso a dados que foi lançada.
     * @return {@link ResponseEntity} contendo a mensagem de erro personalizada com status 400 Bad Request.
     */
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<String> handleDataAccessException(DataAccessException ex) {
        // Mensagem personalizada para problemas de banco de dados
        String errorMessage = "Erro no SQL: " + ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    /**
     * Trata exceções gerais que não são capturadas por outros manipuladores específicos.
     *
     * Este método captura todas as exceções que são subclasses de {@link Exception}
     * e retorna uma resposta HTTP apropriada com uma mensagem de erro genérica.
     *
     * @param ex A exceção geral que foi lançada.
     * @return {@link ResponseEntity} contendo a mensagem de erro genérica com status 500 Internal Server Error.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        // Mensagem genérica para outros erros
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("Erro interno do servidor: " + ex.getMessage());
    }
}
