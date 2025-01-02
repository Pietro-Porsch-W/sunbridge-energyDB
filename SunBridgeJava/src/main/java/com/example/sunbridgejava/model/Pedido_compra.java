package com.example.sunbridgejava.model;

import java.sql.Date;

import jakarta.persistence.*;

/**
 * Representa um {@link Pedido_compra} no sistema.
 * 
 * <p>
 * Esta classe é mapeada para a tabela {@code pedido_compra} no banco de dados e contém informações detalhadas sobre
 * cada pedido de compra realizado, incluindo datas, valores, descontos, usuário responsável, fornecedor associado e
 * pagamento relacionado.
 * </p>
 * 
 * <p>
 * As anotações JPA são utilizadas para definir o mapeamento da entidade para a tabela correspondente no banco de dados,
 * bem como as relações com outras entidades como {@link Usuario}, {@link Fornecedor} e {@link Pagamento_fornecedor}.
 * </p>
 * 
 * <p>
 * <strong>Exemplo de uso:</strong>
 * </p>
 * <pre>
 * Usuario usuario = new Usuario();
 * Fornecedor fornecedor = new Fornecedor();
 * Pagamento_fornecedor pagamentoFornecedor = new Pagamento_fornecedor();
 * 
 * Pedido_compra pedidoCompra = new Pedido_compra(
 *     Date.valueOf("2024-06-01"),
 *     Date.valueOf("2024-06-15"),
 *     5000.00,
 *     500.00,
 *     usuario,
 *     fornecedor,
 *     pagamentoFornecedor
 * );
 * // Persistir o pedidoCompra no banco de dados utilizando um EntityManager
 * </pre>
 * 
 * @version 1.0
 * @since 2024-04-27
 */
@Entity
@Table(name = "pedido_compra")
public class Pedido_compra {

    /**
     * Identificador único do pedido de compra.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ped_compra;

    /**
     * Data em que a compra foi realizada.
     */
    @Column(nullable = false)
    private java.sql.Date data_compra;

    /**
     * Data prevista para a entrega.
     */
    @Column
    private java.sql.Date data_entrega;

    /**
     * Valor total do pedido de compra.
     */
    @Column(nullable = false)
    private double valor;

    /**
     * Desconto aplicado ao pedido de compra.
     */
    @Column
    private double desconto;

    /**
     * Usuário responsável pelo pedido de compra.
     */
    @ManyToOne
    @JoinColumn(name = "usuarioID", nullable = false)
    private Usuario usuarioID;

    /**
     * Fornecedor associado ao pedido de compra.
     */
    @ManyToOne
    @JoinColumn(name = "fornecedorID", nullable = false)
    private Fornecedor fornecedorID;

    /**
     * Pagamento feito ao fornecedor referente a este pedido.
     */
    @OneToOne
    @JoinColumn(name = "pagamento_fornecedorID", nullable = false)
    private Pagamento_fornecedor pagamento_fornecedorID;

    /**
     * Construtor completo da classe {@link Pedido_compra}.
     *
     * @param dt_compra            Data da compra.
     * @param dt_venda             Data de entrega.
     * @param valor                Valor total do pedido.
     * @param desconto             Desconto aplicado.
     * @param usuarioID            Usuário responsável pelo pedido.
     * @param fornecedorID         Fornecedor associado.
     * @param pagamento_fornecedor Pagamento feito ao fornecedor.
     */
    public Pedido_compra(java.sql.Date dt_compra, java.sql.Date dt_venda, double valor, double desconto, 
                         Usuario usuarioID, Fornecedor fornecedorID, Pagamento_fornecedor pagamento_fornecedor) {
        this.data_compra = dt_compra;
        this.data_entrega = dt_venda;
        this.valor = valor;
        this.desconto = desconto;
        this.usuarioID = usuarioID;
        this.fornecedorID = fornecedorID;
        this.pagamento_fornecedorID = pagamento_fornecedor;
    }

    /**
     * Construtor padrão da classe {@link Pedido_compra}.
     */
    public Pedido_compra() {

    }

    /**
     * Obtém o identificador único do pedido de compra.
     *
     * @return {@code int} representando o ID do pedido de compra.
     */
    public int getPed_compra() {
        return ped_compra;
    }

    /**
     * Define o identificador único do pedido de compra.
     *
     * @param ped_compra {@code int} representando o novo ID do pedido de compra.
     */
    public void setPed_compra(int ped_compra) {
        this.ped_compra = ped_compra;
    }

    /**
     * Obtém a data da compra.
     *
     * @return {@code Date} representando a data da compra.
     */
    public Date getData_compra() {
        return data_compra;
    }

    /**
     * Define a data da compra.
     *
     * @param data_compra {@code Date} representando a nova data da compra.
     */
    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }

    /**
     * Obtém a data prevista para a entrega.
     *
     * @return {@code Date} representando a data prevista para a entrega.
     */
    public Date getData_entrega() {
        return data_entrega;
    }

    /**
     * Define a data prevista para a entrega.
     *
     * @param data_entrega {@code Date} representando a nova data prevista para a entrega.
     */
    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }

    /**
     * Obtém o valor total do pedido de compra.
     *
     * @return {@code double} representando o valor total do pedido.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Define o valor total do pedido de compra.
     *
     * @param valor {@code double} representando o novo valor total do pedido.
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Obtém o desconto aplicado ao pedido de compra.
     *
     * @return {@code double} representando o desconto aplicado.
     */
    public double getDesconto() {
        return desconto;
    }

    /**
     * Define o desconto aplicado ao pedido de compra.
     *
     * @param desconto {@code double} representando o novo desconto aplicado.
     */
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    /**
     * Obtém o usuário responsável pelo pedido de compra.
     *
     * @return {@link Usuario} representando o usuário responsável.
     */
    public Usuario getUsuarioID() {
        return usuarioID;
    }

    /**
     * Define o usuário responsável pelo pedido de compra.
     *
     * @param usuarioID {@link Usuario} representando o novo usuário responsável.
     */
    public void setUsuarioID(Usuario usuarioID) {
        this.usuarioID = usuarioID;
    }

    /**
     * Obtém o fornecedor associado ao pedido de compra.
     *
     * @return {@link Fornecedor} representando o fornecedor associado.
     */
    public Fornecedor getFornecedorID() {
        return fornecedorID;
    }

    /**
     * Define o fornecedor associado ao pedido de compra.
     *
     * @param fornecedorID {@link Fornecedor} representando o novo fornecedor associado.
     */
    public void setFornecedorID(Fornecedor fornecedorID) {
        this.fornecedorID = fornecedorID;
    }

    /**
     * Obtém o pagamento feito ao fornecedor referente a este pedido.
     *
     * @return {@link Pagamento_fornecedor} representando o pagamento feito ao fornecedor.
     */
    public Pagamento_fornecedor getPagamento_fornecedorID() {
        return pagamento_fornecedorID;
    }

    /**
     * Define o pagamento feito ao fornecedor referente a este pedido.
     *
     * @param pagamento_fornecedorID {@link Pagamento_fornecedor} representando o novo pagamento feito ao fornecedor.
     */
    public void setPagamento_fornecedorID(Pagamento_fornecedor pagamento_fornecedorID) {
        this.pagamento_fornecedorID = pagamento_fornecedorID;
    }
}
