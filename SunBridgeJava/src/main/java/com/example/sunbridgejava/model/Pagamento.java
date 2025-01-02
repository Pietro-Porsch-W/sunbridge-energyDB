package com.example.sunbridgejava.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

/**
 * Representa um {@link Pagamento} feito por um cliente no sistema.
 * 
 * <p>
 * Esta classe é mapeada para a tabela {@code pagamento} no banco de dados e contém informações detalhadas sobre
 * cada pagamento realizado por um cliente, incluindo data do pagamento, valor pago, forma de pagamento e status.
 * </p>
 * 
 * <p>
 * As anotações JPA são utilizadas para definir o mapeamento da entidade para a tabela correspondente no banco de dados,
 * bem como as relações com outras entidades.
 * </p>
 * 
 * <p>
 * <strong>Exemplo de uso:</strong>
 * </p>
 * <pre>
 * Cliente cliente = new Cliente();
 * // Configurar o cliente conforme necessário
 * Pagamento pagamento = new Pagamento(
 *     cliente,
 *     Date.valueOf("2024-05-15"),
 *     1500.00,
 *     "Transferência Bancária",
 *     "Completado"
 * );
 * // Persistir o pagamento no banco de dados utilizando um EntityManager
 * </pre>
 * 
 * @version 1.0
 * @since 2024-04-27
 */
@Entity
@Table(name = "pagamento")
public class Pagamento {

    /**
     * Identificador único do pagamento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pagamentoID;

    /**
     * Cliente que realizou o pagamento.
     */
    @ManyToOne
    @JoinColumn(name = "clienteID", nullable = false)
    private Cliente clienteID;

    /**
     * Data em que o pagamento foi efetuado.
     */
    @Column(nullable = false)
    private java.sql.Date data_pagamento;

    /**
     * Valor pago pelo cliente.
     */
    @Column(name = "valor", nullable = false)
    private double valor_pago;

    /**
     * Forma como o pagamento foi realizado.
     */
    @Column(name = "forma_pagamento", length = 20, nullable = false)
    private String forma_pagamento;

    /**
     * Status do pagamento.
     */
    @Column(nullable = false)
    private String status_pagamento;

    /**
     * Construtor completo da classe {@link Pagamento}.
     *
     * @param clienteID        Cliente que realizou o pagamento.
     * @param data_pagamento   Data do pagamento.
     * @param valor_pago       Valor pago.
     * @param forma_pagamento  Forma de pagamento.
     * @param status_pagamento Status do pagamento.
     */
    public Pagamento(Cliente clienteID, java.sql.Date data_pagamento, double valor_pago, 
                     String forma_pagamento, String status_pagamento) {
        this.clienteID = clienteID;
        this.data_pagamento = data_pagamento;
        this.valor_pago = valor_pago;
        this.forma_pagamento = forma_pagamento;
        this.status_pagamento = status_pagamento;
    }

    /**
     * Construtor padrão da classe {@link Pagamento}.
     */
    public Pagamento() {

    }

    public Cliente getClienteID() {
        return clienteID;
    }

    public void setClienteID(Cliente clienteID) {
        this.clienteID = clienteID;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public int getPagamentoID() {
        return pagamentoID;
    }

    public void setPagamentoID(int pagamentoID) {
        this.pagamentoID = pagamentoID;
    }

    public String getStatus_pagamento() {
        return status_pagamento;
    }

    public void setStatus_pagamento(String status_pagamento) {
        this.status_pagamento = status_pagamento;
    }

    public double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(double valor_pago) {
        this.valor_pago = valor_pago;
    }
}
