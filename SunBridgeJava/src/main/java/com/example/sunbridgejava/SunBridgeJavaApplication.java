package com.example.sunbridgejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da aplicação Spring Boot {@code SunBridgeJavaApplication}.
 * 
 * Esta classe é responsável por iniciar a aplicação Spring Boot.
 * 
 * <p>
 * A anotação {@link SpringBootApplication} configura a aplicação como uma aplicação Spring Boot,
 * habilitando a configuração automática, a component scanning e outras funcionalidades essenciais.
 * </p>
 */
@SpringBootApplication
public class SunBridgeJavaApplication {

    /**
     * Método principal que inicia a aplicação Spring Boot.
     *
     * @param args Argumentos da linha de comando passados para a aplicação.
     */
    public static void main(String[] args) {
        SpringApplication.run(SunBridgeJavaApplication.class, args);
    }

}
