package com.example.sunbridgejava.model;

import java.sql.Date;

import jakarta.persistence.*;

/**
 * Representa um {@link Pedido_fornecedor} no sistema.
 * 
 * <p>
 * Esta classe é mapeada para a tabela {@code pedido_fornecedor} no banco de dados e contém informações detalhadas sobre
 * cada pedido de fornecedor, incluindo quantidade, valor, associações com pedidos de compra, itens e estoque.
 * </p>
 * 
 * <p>
 * As anotações JPA são utilizadas para definir o mapeamento da entidade para a tabela correspondente no banco de dados,
 * bem como as relações com outras entidades como {@link Pedido_compra}, {@link Item} e {@link Estoque}.
 * </p>
 * 
 * <p>
 * <strong>Exemplo de uso:</strong>
 * </p>
 * <pre>
 * Pedido_compra pedidoCompra = new Pedido_compra();
 * Item item = new Item();
 * Estoque estoque = new Estoque();
 * 
 * Pedido_fornecedor pedidoFornecedor = new Pedido_fornecedor(
 *     pedidoCompra,
 *     10,
 *     2500.00,
 *     item,
 *     estoque
 * );
 * // Persistir o pedidoFornecedor no banco de dados utilizando um EntityManager
 * </pre>
 * 
 * @version 1.0
 * @since 2024-04-27
 */
@Entity
@Table(name = "pedido_fornecedor")
public class Pedido_fornecedor {

    /**
     * Identificador único do pedido de fornecedor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pedido_forID;

    /**
     * Quantidade do item no pedido de fornecedor.
     */
    @Column(nullable = false)
    private int quantidade;

    /**
     * Valor total do pedido de fornecedor.
     */
    @Column(nullable = false)
    private double valor;

    /**
     * Pedido de compra associado ao pedido de fornecedor.
     */
    @ManyToOne
    @JoinColumn(name = "pedido_compra", nullable = false)
    private Pedido_compra pedido_compra;

    /**
     * Item associado ao pedido de fornecedor.
     */
    @OneToOne
    @JoinColumn(name = "it_cod", nullable = false)
    private Item it_cod;

    /**
     * Estoque associado ao pedido de fornecedor.
     */
    @OneToOne
    @JoinColumn(name = "estoqueID", nullable = false)
    private Estoque estoqueID;

    /**
     * Construtor completo da classe {@link Pedido_fornecedor}.
     *
     * @param pedido_compra Pedido de compra associado.
     * @param quantidade    Quantidade do item no pedido.
     * @param valor         Valor total do pedido.
     * @param it_cod        Item associado ao pedido.
     * @param estoqueID     Estoque associado ao pedido.
     */
    public Pedido_fornecedor(Pedido_compra pedido_compra, int quantidade, double valor, Item it_cod,
                             Estoque estoqueID) {
        this.pedido_compra = pedido_compra;
        this.quantidade = quantidade;
        this.valor = valor;
        this.it_cod = it_cod;
        this.estoqueID = estoqueID;
    }

    /**
     * Construtor padrão da classe {@link Pedido_fornecedor}.
     */
    public Pedido_fornecedor() {

    }

    /**
     * Obtém o identificador único do pedido de fornecedor.
     *
     * @return {@code int} representando o ID do pedido de fornecedor.
     */
    public int getPedido_forID() {
        return pedido_forID;
    }

    /**
     * Define o identificador único do pedido de fornecedor.
     *
     * @param pedido_forID {@code int} representando o novo ID do pedido de fornecedor.
     */
    public void setPedido_forID(int pedido_forID) {
        this.pedido_forID = pedido_forID;
    }

    /**
     * Obtém a quantidade do item no pedido de fornecedor.
     *
     * @return {@code int} representando a quantidade do item.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade do item no pedido de fornecedor.
     *
     * @param quantidade {@code int} representando a nova quantidade do item.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Obtém o valor total do pedido de fornecedor.
     *
     * @return {@code double} representando o valor total do pedido.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Define o valor total do pedido de fornecedor.
     *
     * @param valor {@code double} representando o novo valor total do pedido.
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Obtém o pedido de compra associado ao pedido de fornecedor.
     *
     * @return {@link Pedido_compra} representando o pedido de compra associado.
     */
    public Pedido_compra getPedido_compra() {
        return pedido_compra;
    }

    /**
     * Define o pedido de compra associado ao pedido de fornecedor.
     *
     * @param pedido_compra {@link Pedido_compra} representando o novo pedido de compra associado.
     */
    public void setPedido_compra(Pedido_compra pedido_compra) {
        this.pedido_compra = pedido_compra;
    }

    /**
     * Obtém o item associado ao pedido de fornecedor.
     *
     * @return {@link Item} representando o item associado.
     */
    public Item getIt_cod() {
        return it_cod;
    }

    /**
     * Define o item associado ao pedido de fornecedor.
     *
     * @param it_cod {@link Item} representando o novo item associado.
     */
    public void setIt_cod(Item it_cod) {
        this.it_cod = it_cod;
    }

    /**
     * Obtém o estoque associado ao pedido de fornecedor.
     *
     * @return {@link Estoque} representando o estoque associado.
     */
    public Estoque getEstoqueID() {
        return estoqueID;
    }

    /**
     * Define o estoque associado ao pedido de fornecedor.
     *
     * @param estoqueID {@link Estoque} representando o novo estoque associado.
     */
    public void setEstoqueID(Estoque estoqueID) {
        this.estoqueID = estoqueID;
    }
}
