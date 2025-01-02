package com.example.sunbridgejava.model;

import jakarta.persistence.*;

/**
 * Representa um {@link Item} no sistema.
 * 
 * <p>
 * Esta classe é mapeada para a tabela {@code item} no banco de dados e contém informações detalhadas sobre cada item,
 * incluindo dados de identificação, descrição, quantidade disponível, valores, categoria e associação com o estoque.
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
 * Estoque estoque = new Estoque();
 * // Configurar o objeto estoque conforme necessário
 * 
 * Item item = new Item(
 *     "Laptop Exemplo",
 *     "Laptop de alta performance com 16GB RAM e 512GB SSD.",
 *     50,
 *     2500.00,
 *     "Eletrônicos",
 *     estoque
 * );
 * </pre>
 * 
 * @version 1.0
 * @since 2024-04-27
 */
@Entity
@Table(name = "item")
public class Item {

    /**
     * Código identificador do item.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int it_cod;

    /**
     * Nome do item.
     */
    @Column(length = 40, nullable = false)
    private String nome;

    /**
     * Descrição do item.
     */
    @Column(length = 255)
    private String descricao;

    /**
     * Quantidade disponível do item.
     */
    @Column(nullable = false)
    private int quantidade;

    /**
     * Valor do item.
     */
    @Column(nullable = false)
    private double valor;

    /**
     * Categoria do item.
     */
    @Column(length = 100, nullable = false)
    private String categoria;

    /**
     * Estoque associado ao item.
     */
    @OneToOne
    @JoinColumn(name = "estoqueID", nullable = false)
    private Estoque estoqueID;

    /**
     * Construtor completo da classe {@link Item}.
     *
     * @param nome        Nome do item.
     * @param descricao   Descrição do item.
     * @param quantidade  Quantidade disponível.
     * @param valor       Valor do item.
     * @param categoria   Categoria do item.
     * @param estoqueID   Estoque associado.
     */
    public Item(String nome, String descricao, int quantidade,
                double valor, String categoria, Estoque estoqueID) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
        this.categoria = categoria;
        this.estoqueID = estoqueID;
    }

    public Item() {

    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Estoque getEstoqueID() {
        return estoqueID;
    }

    public void setEstoqueID(Estoque estoqueID) {
        this.estoqueID = estoqueID;
    }

    public int getIt_cod() {
        return it_cod;
    }

    public void setIt_cod(int it_cod) {
        this.it_cod = it_cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
