package com.example.sunbridgejava.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

/**
 * Representa um pedido de venda no sistema.
 * 
 * <p>
 * Esta classe é mapeada para a tabela {@code pedido_venda} no banco de dados e contém informações sobre os pedidos
 * realizados pelos clientes, incluindo dados do cliente, data da venda, data de instalação, valor total e descontos aplicados.
 * </p>
 * 
 * <p>
 * A entidade utiliza relacionamentos JPA para associar cada pedido de venda a um cliente por meio da entidade {@link Cliente}.
 * </p>
 * 
 * @version 1.0
 * @since 2024-04-27
 */
@Entity
@Table(name = "pedido_venda")
public class Pedido_venda {

    /**
     * Identificador único do pedido de venda.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ped_venda;

    /**
     * Cliente associado ao pedido de venda.
     */
    @ManyToOne
    @JoinColumn(name = "clienteID", nullable = false) 
    private Cliente clienteID;

    /**
     * Data em que a venda foi realizada.
     */
    @Column(nullable = false)
    private java.sql.Date data_venda;

    /**
     * Data prevista para a instalação.
     */
    @Column
    private java.sql.Date data_instalacao;

    /**
     * Valor total do pedido de venda.
     */
    @Column(nullable = false)
    private double valor;

    /**
     * Desconto aplicado ao pedido de venda.
     */
    @Column(nullable = false)
    private double desconto;

    /**
     * Construtor completo da classe {@link Pedido_venda}.
     *
     * @param clienteID      Cliente associado ao pedido.
     * @param dt_venda       Data da venda.
     * @param dt_instalacao  Data prevista para a instalação.
     * @param valor          Valor total do pedido.
     * @param desconto       Desconto aplicado ao pedido.
     */
    public Pedido_venda(Cliente clienteID, Date dt_venda, Date dt_instalacao, double valor, double desconto) {
        this.clienteID = clienteID;
        this.data_venda = dt_venda;
        this.data_instalacao = dt_instalacao;
        this.valor = valor;
        this.desconto = desconto;
    }

    /**
     * Construtor padrão da classe {@link Pedido_venda}.
     */
    public Pedido_venda() {

    }

    /**
     * Obtém o identificador único do pedido de venda.
     *
     * @return {@code int} representando o ID do pedido de venda.
     */
    public int getPed_venda() {
        return ped_venda;
    }

    /**
     * Define o identificador único do pedido de venda.
     *
     * @param ped_venda {@code int} representando o novo ID do pedido de venda.
     */
    public void setPed_venda(int ped_venda) {
        this.ped_venda = ped_venda;
    }

    /**
     * Obtém o cliente associado ao pedido de venda.
     *
     * @return {@link Cliente} representando o cliente associado.
     */
    public Cliente getClienteID() {
        return clienteID;
    }

    /**
     * Define o cliente associado ao pedido de venda.
     *
     * @param clienteID {@link Cliente} representando o novo cliente associado.
     */
    public void setClienteID(Cliente clienteID) {
        this.clienteID = clienteID;
    }

    /**
     * Obtém a data em que a venda foi realizada.
     *
     * @return {@code Date} representando a data da venda.
     */
    public Date getData_venda() {
        return data_venda;
    }

    /**
     * Define a data em que a venda foi realizada.
     *
     * @param data_venda {@code Date} representando a nova data da venda.
     */
    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    /**
     * Obtém a data prevista para a instalação.
     *
     * @return {@code Date} representando a data de instalação.
     */
    public Date getData_instalacao() {
        return data_instalacao;
    }

    /**
     * Define a data prevista para a instalação.
     *
     * @param data_instalacao {@code Date} representando a nova data de instalação.
     */
    public void setData_instalacao(Date data_instalacao) {
        this.data_instalacao = data_instalacao;
    }

    /**
     * Obtém o valor total do pedido de venda.
     *
     * @return {@code double} representando o valor total do pedido.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Define o valor total do pedido de venda.
     *
     * @param valor {@code double} representando o novo valor total do pedido.
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Obtém o desconto aplicado ao pedido de venda.
     *
     * @return {@code double} representando o desconto aplicado.
     */
    public double getDesconto() {
        return desconto;
    }

    /**
     * Define o desconto aplicado ao pedido de venda.
     *
     * @param desconto {@code double} representando o novo desconto aplicado.
     */
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}
