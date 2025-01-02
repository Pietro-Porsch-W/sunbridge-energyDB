package com.example.sunbridgejava.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Utilitário para gerenciar a criação e o fechamento do {@code EntityManager} e {@code EntityManagerFactory}.
 * 
 * <p>
 * Esta classe fornece métodos para criar instâncias de {@code EntityManager} a partir de uma 
 * unidade de persistência configurada no arquivo {@code persistence.xml}.
 * </p>
 */
public class JPAUtil {

    /**
     * {@code EntityManagerFactory} configurado com a unidade de persistência {@code jpapersistencia}.
     */
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("jpapersistencia");

    /**
     * Construtor privado para impedir a instância direta da classe.
     */
    private JPAUtil() {
    }

    /**
     * Cria e retorna uma nova instância de {@code EntityManager}.
     * 
     * @return Nova instância de {@code EntityManager}.
     */
    public static EntityManager getEntityManager() {
        return EMF.createEntityManager();
    }

    /**
     * Fecha o {@code EntityManagerFactory} para liberar os recursos.
     * 
     * <p>
     * Este método deve ser chamado apenas uma vez, geralmente no encerramento da aplicação.
     * </p>
     */
    public static void closeEntityManagerFactory() {
        EMF.close();
    }
}
