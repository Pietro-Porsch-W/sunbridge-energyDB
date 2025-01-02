package com.example.sunbridgejava.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representa um {@link Fornecedor} no sistema.
 * 
 * <p>
 * Esta classe é mapeada para a tabela {@code fornecedor} no banco de dados e contém informações detalhadas sobre cada fornecedor,
 * incluindo dados de contato e endereço.
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
 * Fornecedor fornecedor = new Fornecedor(
 *     "123456789012",
 *     "Fornecedor Exemplo",
 *     "555-1234",
 *     "Rua Exemplo",
 *     "Bairro Exemplo",
 *     "Cidade Exemplo",
 *     "Província Exemplo",
 *     "Cantão Exemplo",
 *     "Distrito Exemplo",
 *     "12345-678",
 *     "Apto 101"
 * );
 * </pre>
 * 
 * @version 1.0
 * @since 2024-04-27
 */
@Entity
@Table(name = "fornecedor")
public class Fornecedor {

    /**
     * Identificador único do fornecedor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fornecedorID;
    
    /**
     * Nome do fornecedor.
     */
    @Column(length = 40, nullable = false)
    private String nome;

    /**
     * Cédula do fornecedor.
     */
    @Column(length = 12, nullable = false)
    private String cedula;
         
    /**
     * Telefone do fornecedor.
     */
    @Column(length = 20, nullable = false)
    private String telefone;

    /**
     * Rua do endereço do fornecedor.
     */
    @Column(length = 60, nullable = false)
    private String rua;
    
    /**
     * Bairro do endereço do fornecedor.
     */
    @Column(length = 60, nullable = false)
    private String bairro;
    
    /**
     * Cidade do endereço do fornecedor.
     */
    @Column(length = 50, nullable = false)
    private String cidade;
    
    /**
     * Província do endereço do fornecedor.
     */
    @Column(length = 50, nullable = false)
    private String provincia;
    
    /**
     * Cantão do endereço do fornecedor.
     */
    @Column(length = 50, nullable = false)
    private String canton;
    
    /**
     * Distrito do endereço do fornecedor.
     */
    @Column(length = 50, nullable = false)
    private String distrito;
    
    /**
     * Código postal do endereço do fornecedor.
     */
    @Column(length = 10, nullable = false)
    private int codigo_postal;
    
    /**
     * Complemento do endereço do fornecedor.
     */
    @Column(length = 60)
    private String complemento;

    /**
     * Construtor completo da classe {@link Fornecedor}.
     *
     * @param cedula          Cédula do fornecedor.
     * @param nome            Nome do fornecedor.
     * @param telefone        Telefone do fornecedor.
     * @param rua             Rua do endereço.
     * @param bairro          Bairro do endereço.
     * @param cidade          Cidade do endereço.
     * @param provincia       Província do endereço.
     * @param canton          Cantão do endereço.
     * @param distrito        Distrito do endereço.
     * @param codigo_postal   Código postal do endereço.
     * @param complemento     Complemento do endereço.
     */
    public Fornecedor(String cedula, String nome, String telefone,
                      String rua, String bairro, String cidade, String provincia, 
                      String canton, String distrito, int codigo_postal,
                      String complemento) {
        this.cedula = cedula;
        this.nome = nome;
        this.telefone = telefone;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.codigo_postal = codigo_postal;
        this.complemento = complemento;
    }

    /**
     * Construtor padrão da classe {@link Fornecedor}.
     */
    public Fornecedor() {

    }


    /**
     * Obtém o identificador único do fornecedor.
     *
     * @return {@code int} representando o ID do fornecedor.
     */
    public int getFornecedorID() {
        return fornecedorID;
    }

    /**
     * Define o identificador único do fornecedor.
     *
     * @param fornecedorID {@code int} representando o novo ID do fornecedor.
     */
    public void setFornecedorID(int fornecedorID) {
        this.fornecedorID = fornecedorID;
    }

    /**
     * Obtém o nome do fornecedor.
     *
     * @return {@code String} representando o nome do fornecedor.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do fornecedor.
     *
     * @param nome {@code String} representando o novo nome do fornecedor.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a cédula do fornecedor.
     *
     * @return {@code String} representando a cédula do fornecedor.
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Define a cédula do fornecedor.
     *
     * @param cedula {@code String} representando a nova cédula do fornecedor.
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtém o telefone do fornecedor.
     *
     * @return {@code String} representando o telefone do fornecedor.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do fornecedor.
     *
     * @param telefone {@code String} representando o novo telefone do fornecedor.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obtém a rua do endereço do fornecedor.
     *
     * @return {@code String} representando a rua do fornecedor.
     */
    public String getRua() {
        return rua;
    }

    /**
     * Define a rua do endereço do fornecedor.
     *
     * @param rua {@code String} representando a nova rua do fornecedor.
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * Obtém o bairro do endereço do fornecedor.
     *
     * @return {@code String} representando o bairro do fornecedor.
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Define o bairro do endereço do fornecedor.
     *
     * @param bairro {@code String} representando o novo bairro do fornecedor.
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * Obtém a cidade do endereço do fornecedor.
     *
     * @return {@code String} representando a cidade do fornecedor.
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Define a cidade do endereço do fornecedor.
     *
     * @param cidade {@code String} representando a nova cidade do fornecedor.
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * Obtém a província do endereço do fornecedor.
     *
     * @return {@code String} representando a província do fornecedor.
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Define a província do endereço do fornecedor.
     *
     * @param provincia {@code String} representando a nova província do fornecedor.
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Obtém o cantão do endereço do fornecedor.
     *
     * @return {@code String} representando o cantão do fornecedor.
     */
    public String getCanton() {
        return canton;
    }

    /**
     * Define o cantão do endereço do fornecedor.
     *
     * @param canton {@code String} representando o novo cantão do fornecedor.
     */
    public void setCanton(String canton) {
        this.canton = canton;
    }

    /**
     * Obtém o distrito do endereço do fornecedor.
     *
     * @return {@code String} representando o distrito do fornecedor.
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     * Define o distrito do endereço do fornecedor.
     *
     * @param distrito {@code String} representando o novo distrito do fornecedor.
     */
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }


    public int getCodigo_postal() {
        return codigo_postal;
    }


    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    /**
     * Obtém o complemento do endereço do fornecedor.
     *
     * @return {@code String} representando o complemento do fornecedor.
     */

    public String getComplemento() {
        return complemento;
    }

    /**
     * Define o complemento do endereço do fornecedor.
     *
     * @param complemento {@code String} representando o novo complemento do fornecedor.
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
