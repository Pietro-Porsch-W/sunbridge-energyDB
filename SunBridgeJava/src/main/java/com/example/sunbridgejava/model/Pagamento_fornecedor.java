package com.example.sunbridgejava.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representa um {@link Pagamento_fornecedor} no sistema.
 * 
 * <p>
 * Esta classe é mapeada para a tabela {@code pagamento_fornecedor} no banco de dados e contém informações detalhadas sobre
 * cada pagamento realizado para um fornecedor, incluindo data do pagamento, valor, e forma de pagamento.
 * </p>
 * 
 * <p>
 * As anotações JPA são utilizadas para definir o mapeamento da entidade para a tabela correspondente no banco de dados,
 * bem como as restrições e características de cada coluna.
 * </p>
 * 
 * <p>
 * <strong>Exemplo de uso:</strong>
 * </p>
 * <pre>
 * Pagamento_fornecedor pagamento = new Pagamento_fornecedor(
 *     Date.valueOf("2024-05-15"),
 *     1500.00,
 *     "Transferência Bancária"
 * );
 * // Persistir o pagamento no banco de dados utilizando um EntityManager
 * </pre>
 * 
 * @version 1.0
 * @since 2024-04-27
 */
@Entity
@Table(name = "pagamento_fornecedor")
public class Pagamento_fornecedor {

    /**
     * Identificador único do pagamento do fornecedor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pagamento_fornecedorID;

    /**
     * Data em que o pagamento foi efetuado.
     */
    @Column(nullable = false)
    private java.sql.Date data_pagamento;

    /**
     * Valor do pagamento.
     */
    @Column(name = "valor", nullable = false)
    private Double valor;

    /**
     * Forma como o pagamento foi realizado.
     */
    @Column(name = "forma_pagamento", length = 20)
    private String forma_pagamento;

    /**
     * Construtor completo da classe {@link Pagamento_fornecedor}.
     *
     * @param dataFornecedor   Data do pagamento.
     * @param valor            Valor do pagamento.
     * @param forma_pagamento  Forma de pagamento.
     */
    public Pagamento_fornecedor(java.sql.Date dataFornecedor, Double valor, String forma_pagamento) {
        this.data_pagamento = dataFornecedor;
        this.valor = valor;
        this.forma_pagamento = forma_pagamento;
    }

    /**
     * Construtor padrão da classe {@link Pagamento_fornecedor}.
     */
    public Pagamento_fornecedor() {

    }

    /**
     * Obtém o identificador único do pagamento do fornecedor.
     *
     * @return {@code int} representando o ID do pagamento do fornecedor.
     */
    public int getPagamento_fornecedorID() {
        return pagamento_fornecedorID;
    }

    /**
     * Define o identificador único do pagamento do fornecedor.
     *
     * @param pagamento_fornecedorID {@code int} representando o novo ID do pagamento.
     */
    public void setPagamento_fornecedorID(int pagamento_fornecedorID) {
        this.pagamento_fornecedorID = pagamento_fornecedorID;
    }

    /**
     * Obtém a data do pagamento.
     *
     * @return {@code Date} representando a data do pagamento.
     */
    public Date getData_pagamento() {
        return data_pagamento;
    }

    /**
     * Define a data do pagamento.
     *
     * @param data_pagamento {@code Date} representando a nova data do pagamento.
     */
    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    /**
     * Obtém o valor do pagamento.
     *
     * @return {@code Double} representando o valor do pagamento.
     */
    public Double getValor() {
        return valor;
    }

    /**
     * Define o valor do pagamento.
     *
     * @param valor {@code Double} representando o novo valor do pagamento.
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * Obtém a forma de pagamento.
     *
     * @return {@code String} representando a forma de pagamento.
     */
    public String getForma_pagamento() {
        return forma_pagamento;
    }

    /**
     * Define a forma de pagamento.
     *
     * @param forma_pagamento {@code String} representando a nova forma de pagamento.
     */
    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }
}
