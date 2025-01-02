package com.example.sunbridgejava.model;

import jakarta.persistence.*;

/**
 * Representa um {@link Item_venda} no sistema.
 * 
 * <p>
 * Esta classe é mapeada para a tabela {@code item_venda} no banco de dados e contém informações detalhadas sobre cada item de venda,
 * incluindo associação ao pedido de venda, quantidade, valores, descrição, marca, garantia, composição, origem e código do item.
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
 * Pedido_venda pedido = new Pedido_venda();
 * Item item = new Item();
 * Item_venda itemVenda = new Item_venda(
 *     pedido,
 *     2,
 *     299.99,
 *     "Descrição detalhada do produto.",
 *     "Marca Exemplo",
 *     24,
 *     "Composição do produto.",
 *     "Origem do produto.",
 *     item
 * );
 * </pre>
 * 
 * @version 1.0
 * @since 2024-04-27
 */
@Entity
@Table(name = "item_venda")
public class Item_venda {

    /**
     * Identificador único do item de venda.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemID;
    
    /**
     * Pedido de venda associado ao item.
     */
    @ManyToOne
    @JoinColumn(name = "ped_venda", nullable = false)
    private Pedido_venda ped_venda;

    /**
     * Quantidade do item vendido.
     */
    @Column(nullable = false)
    private int quantidade;
    
    /**
     * Valor do produto.
     */
    @Column
    private double valor_prod;

    /**
     * Descrição do produto.
     */
    @Column(length = 255)
    private String descricao;
    
    /**
     * Marca do produto.
     */
    @Column(length = 100)
    private String marca;

    /**
     * Garantia do produto em meses.
     */
    @Column
    private int garantia;

    /**
     * Composição do produto.
     */
    @Column(length = 255)
    private String composicao;

    /**
     * Origem do produto.
     */
    @Column(length = 255)
    private String origem;

    /**
     * Código do item.
     */
    @OneToOne
    @JoinColumn(name = "it_cod", nullable = false)
    private Item it_cod;

    /**
     * Construtor completo da classe {@link Item_venda}.
     *
     * @param ped_venda   Pedido de venda associado.
     * @param quantidade  Quantidade vendida.
     * @param valor_prod  Valor do produto.
     * @param descricao   Descrição do produto.
     * @param marca       Marca do produto.
     * @param garantia    Garantia do produto em meses.
     * @param composicao  Composição do produto.
     * @param origem      Origem do produto.
     * @param it_cod      Código do item.
     */
    public Item_venda(Pedido_venda ped_venda, int quantidade, double valor_prod, 
                      String descricao, String marca, int garantia, String composicao, 
                      String origem, Item it_cod) {
        this.ped_venda = ped_venda;
        this.quantidade = quantidade;
        this.valor_prod = valor_prod;
        this.descricao = descricao;
        this.marca = marca;
        this.garantia = garantia;
        this.composicao = composicao;
        this.origem = origem;
        this.it_cod = it_cod;
    }

    /**
     * Construtor padrão da classe {@link Item_venda}.
     */
    public Item_venda() {

    }

    /**
     * Obtém o identificador único do item de venda.
     *
     * @return {@code int} representando o ID do item de venda.
     */
    public int getItemID() {
        return itemID;
    }

    /**
     * Define o identificador único do item de venda.
     *
     * @param itemID {@code int} representando o novo ID do item de venda.
     */
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    /**
     * Obtém o pedido de venda associado ao item.
     *
     * @return {@link Pedido_venda} representando o pedido de venda associado.
     */
    public Pedido_venda getPed_venda() {
        return ped_venda;
    }

    /**
     * Define o pedido de venda associado ao item.
     *
     * @param ped_venda {@link Pedido_venda} representando o novo pedido de venda associado.
     */
    public void setPed_venda(Pedido_venda ped_venda) {
        this.ped_venda = ped_venda;
    }

    /**
     * Obtém a quantidade vendida do item.
     *
     * @return {@code int} representando a quantidade vendida.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade vendida do item.
     *
     * @param quantidade {@code int} representando a nova quantidade vendida.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Obtém o valor do produto.
     *
     * @return {@code double} representando o valor do produto.
     */
    public double getValor_prod() {
        return valor_prod;
    }

    /**
     * Define o valor do produto.
     *
     * @param valor_prod {@code double} representando o novo valor do produto.
     */
    public void setValor_prod(double valor_prod) {
        this.valor_prod = valor_prod;
    }

    /**
     * Obtém a descrição do produto.
     *
     * @return {@code String} representando a descrição do produto.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do produto.
     *
     * @param descricao {@code String} representando a nova descrição do produto.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém a marca do produto.
     *
     * @return {@code String} representando a marca do produto.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Define a marca do produto.
     *
     * @param marca {@code String} representando a nova marca do produto.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtém a garantia do produto em meses.
     *
     * @return {@code int} representando a garantia do produto.
     */
    public int getGarantia() {
        return garantia;
    }

    /**
     * Define a garantia do produto em meses.
     *
     * @param garantia {@code int} representando a nova garantia do produto.
     */
    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    /**
     * Obtém a composição do produto.
     *
     * @return {@code String} representando a composição do produto.
     */
    public String getComposicao() {
        return composicao;
    }

    /**
     * Define a composição do produto.
     *
     * @param composicao {@code String} representando a nova composição do produto.
     */
    public void setComposicao(String composicao) {
        this.composicao = composicao;
    }

    /**
     * Obtém a origem do produto.
     *
     * @return {@code String} representando a origem do produto.
     */
    public String getOrigem() {
        return origem;
    }

    /**
     * Define a origem do produto.
     *
     * @param origem {@code String} representando a nova origem do produto.
     */
    public void setOrigem(String origem) {
        this.origem = origem;
    }

    /**
     * Obtém o código do item.
     *
     * @return {@link Item} representando o código do item.
     */
    public Item getIt_cod() {
        return it_cod;
    }

    /**
     * Define o código do item.
     *
     * @param it_cod {@link Item} representando o novo código do item.
     */
    public void setIt_cod(Item it_cod) {
        this.it_cod = it_cod;
    }
}
