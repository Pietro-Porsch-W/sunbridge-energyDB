package com.example.sunbridgejava.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representa um {@link Estoque} no sistema.
 * 
 * <p>
 * Esta classe é mapeada para a tabela {@code estoque} no banco de dados e contém informações detalhadas sobre cada item de estoque,
 * incluindo localização, peso, datas de entrada e saída, bem como valores de compra e venda.
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
 * Estoque estoque = new Estoque(
 *     "Rua Exemplo",
 *     "Prateleira A1",
 *     50,
 *     Date.valueOf("2024-01-15"),
 *     Date.valueOf("2024-02-20"),
 *     100.0,
 *     150.0
 * );
 * </pre>
 * 
 * @version 1.0
 * @since 2024-04-27
 */
@Entity
@Table(name = "estoque")
public class Estoque {

    /**
     * Identificador único do estoque.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int estoqueID;

    /**
     * Rua onde o item está armazenado.
     */
    @Column(length = 60, nullable = false)
    private String rua;

    /**
     * Prateleira onde o item está localizado.
     */
    @Column(length = 30, nullable = false)
    private String prateleira;

    /**
     * Peso do item em estoque.
     */
    @Column(nullable = false)
    private int peso;

    /**
     * Data de entrada do item no estoque.
     */
    @Column
    private java.sql.Date data_entrada;

    /**
     * Data de saída do item do estoque.
     */
    @Column
    private java.sql.Date data_saida;

    /**
     * Valor de compra do item.
     */
    @Column
    private double valor_compra;

    /**
     * Valor de venda do item.
     */
    @Column(nullable = false)
    private double valor_venda;

    /**
     * Construtor completo da classe {@link Estoque}.
     *
     * @param rua           Rua onde o item está armazenado.
     * @param prateleira    Prateleira onde o item está localizado.
     * @param peso          Peso do item.
     * @param data_entrada  Data de entrada no estoque.
     * @param data_saida    Data de saída do estoque.
     * @param valor_compra  Valor de compra do item.
     * @param valor_venda   Valor de venda do item.
     */
    public Estoque(String rua, String prateleira, int peso, 
                   java.sql.Date data_entrada, java.sql.Date data_saida, 
                   double valor_compra, double valor_venda) {
        this.rua = rua;
        this.prateleira = prateleira;
        this.peso = peso;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
        this.valor_compra = valor_compra;
        this.valor_venda = valor_venda;
    }

    /**
     * Construtor padrão da classe {@link Estoque}.
     */
    public Estoque() {

    }

    /**
     * Obtém o identificador único do estoque.
     *
     * @return {@code int} representando o ID do estoque.
     */
    public int getEstoqueID() {
        return estoqueID;
    }

    /**
     * Define o identificador único do estoque.
     *
     * @param estoqueID {@code int} representando o novo ID do estoque.
     */
    public void setEstoqueID(int estoqueID) {
        this.estoqueID = estoqueID;
    }

    /**
     * Obtém a rua onde o item está armazenado.
     *
     * @return {@code String} representando a rua do item.
     */
    public String getRua() {
        return rua;
    }

    /**
     * Define a rua onde o item está armazenado.
     *
     * @param rua {@code String} representando a nova rua do item.
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * Obtém a prateleira onde o item está localizado.
     *
     * @return {@code String} representando a prateleira do item.
     */
    public String getPrateleira() {
        return prateleira;
    }

    /**
     * Define a prateleira onde o item está localizado.
     *
     * @param prateleira {@code String} representando a nova prateleira do item.
     */
    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }

    /**
     * Obtém o peso do item em estoque.
     *
     * @return {@code int} representando o peso do item.
     */
    public int getPeso() {
        return peso;
    }

    /**
     * Define o peso do item em estoque.
     *
     * @param peso {@code int} representando o novo peso do item.
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * Obtém a data de entrada do item no estoque.
     *
     * @return {@code Date} representando a data de entrada do item.
     */
    public Date getData_entrada() {
        return data_entrada;
    }

    /**
     * Define a data de entrada do item no estoque.
     *
     * @param data_entrada {@code Date} representando a nova data de entrada do item.
     */
    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    /**
     * Obtém a data de saída do item do estoque.
     *
     * @return {@code Date} representando a data de saída do item.
     */
    public Date getData_saida() {
        return data_saida;
    }

    /**
     * Define a data de saída do item do estoque.
     *
     * @param data_saida {@code Date} representando a nova data de saída do item.
     */
    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    /**
     * Obtém o valor de compra do item.
     *
     * @return {@code double} representando o valor de compra do item.
     */
    public double getValor_compra() {
        return valor_compra;
    }

    /**
     * Define o valor de compra do item.
     *
     * @param valor_compra {@code double} representando o novo valor de compra do item.
     */
    public void setValor_compra(double valor_compra) {
        this.valor_compra = valor_compra;
    }

    /**
     * Obtém o valor de venda do item.
     *
     * @return {@code double} representando o valor de venda do item.
     */
    public double getValor_venda() {
        return valor_venda;
    }

    /**
     * Define o valor de venda do item.
     *
     * @param valor_venda {@code double} representando o novo valor de venda do item.
     */
    public void setValor_venda(double valor_venda) {
        this.valor_venda = valor_venda;
    }
}
