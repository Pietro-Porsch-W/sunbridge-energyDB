package com.example.sunbridgejava.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representa uma {@link Empresa} no sistema.
 * 
 * <p>
 * Esta classe é mapeada para a tabela {@code empresa} no banco de dados e contém informações detalhadas sobre cada empresa,
 * incluindo dados de contato, localização, status de atividade e descrições adicionais.
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
 * Empresa empresa = new Empresa(
 *     "Nome da Empresa",
 *     "https://www.empresa.com",
 *     "contato@empresa.com",
 *     "São Paulo",
 *     "São Paulo",
 *     Date.valueOf("2000-01-01"),
 *     "123456789012",
 *     "Tecnologia",
 *     "LIC-2024-0001",
 *     "Rua Exemplo",
 *     "Bairro Exemplo",
 *     "Cantão Exemplo",
 *     "Distrito Exemplo",
 *     12345,
 *     "Apto 101"
 * );
 * </pre>
 * 
 * @version 1.0
 * @since 2024-04-27
 */
@Entity
@Table(name = "empresa")
public class Empresa {

    /**
     * Identificador único da empresa.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyID;

    /**
     * Nome da empresa.
     */
    @Column(length = 40, nullable = false, unique = true)
    private String nome;

    /**
     * URL do site da empresa.
     */
    @Column(length = 255, nullable = false)
    private String websiteURL;

    /**
     * Email da empresa.
     */
    @Column(length = 60, nullable = false, unique = true)
    private String email;

    /**
     * Telefone da empresa.
     */
    @Column(length = 20, nullable = false)
    private String telefone;

    /**
     * Cidade onde a empresa está localizada.
     */
    @Column(length = 255, nullable = false)
    private String cidade;

    /**
     * Província onde a empresa está localizada.
     */
    @Column(length = 255, nullable = false)
    private String provincia;

    /**
     * Data de fundação da empresa.
     */
    @Column
    private java.sql.Date data_fundacao;

    /**
     * Cédula jurídica da empresa.
     */
    @Column(length = 12, nullable = false)
    private String cedula_juridica;

    /**
     * Setor de atuação da empresa.
     */
    @Column(length = 100)
    private String setor;

    /**
     * Número da licença da empresa.
     */
    @Column(length = 25, nullable = false)
    private String numero_licenca;

    /**
     * Rua do endereço da empresa.
     */
    @Column(length = 60, nullable = false)
    private String rua;

    /**
     * Bairro do endereço da empresa.
     */
    @Column(length = 60, nullable = false)
    private String bairro;

    /**
     * Cantão onde a empresa está localizada.
     */
    @Column(length = 50, nullable = false)
    private String canton;

    /**
     * Distrito onde a empresa está localizada.
     */
    @Column(length = 50, nullable = false)
    private String distrito;

    /**
     * Código postal do endereço da empresa.
     */
    @Column(length = 10, nullable = false)
    private int codigo_postal;

    /**
     * Complemento do endereço da empresa.
     */
    @Column(length = 60)
    private String complemento;

    /**
     * Construtor completo da classe {@link Empresa}.
     *
     * @param nome             Nome da empresa.
     * @param email            Email da empresa.
     * @param telefone         Telefone da empresa.
     * @param cidade           Cidade onde a empresa está localizada.
     * @param provincia        Província onde a empresa está localizada.
     * @param data_fundacao    Data de fundação da empresa.
     * @param cedula_juridica  Cédula jurídica da empresa.
     * @param setor            Setor de atuação da empresa.
     * @param numero_licenca   Número da licença da empresa.
     * @param rua              Rua do endereço da empresa.
     * @param bairro           Bairro do endereço da empresa.
     * @param canton           Cantão onde a empresa está localizada.
     * @param distrito         Distrito onde a empresa está localizada.
     * @param codigo_postal    Código postal do endereço da empresa.
     * @param complemento      Complemento do endereço da empresa.
     */
    public Empresa(String nome, String email,
                   String telefone, String cidade, String provincia,
                   Date data_fundacao, String cedula_juridica,
                   String setor, String numero_licenca, String rua,
                   String bairro, String canton, String distrito,
                   int codigo_postal, String complemento) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cidade = cidade;
        this.provincia = provincia;
        this.data_fundacao = data_fundacao;
        this.cedula_juridica = cedula_juridica;
        this.setor = setor;
        this.numero_licenca = numero_licenca;
        this.rua = rua;
        this.bairro = bairro;
        this.canton = canton;
        this.distrito = distrito;
        this.codigo_postal = codigo_postal;
        this.complemento = complemento;
    }

    /**
     * Construtor padrão da classe {@link Empresa}.
     */
    public Empresa() {

    }

    /**
     * Obtém o identificador único da empresa.
     *
     * @return {@code int} representando o ID da empresa.
     */
    public int getCompanyID() {
        return companyID;
    }

    /**
     * Define o identificador único da empresa.
     *
     * @param companyID {@code int} representando o novo ID da empresa.
     */
    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    /**
     * Obtém o nome da empresa.
     *
     * @return {@code String} representando o nome da empresa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da empresa.
     *
     * @param nome {@code String} representando o novo nome da empresa.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a URL do site da empresa.
     *
     * @return {@code String} representando a URL do site da empresa.
     */
    public String getWebsiteURL() {
        return websiteURL;
    }

    /**
     * Define a URL do site da empresa.
     *
     * @param websiteURL {@code String} representando a nova URL do site da empresa.
     */
    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    /**
     * Obtém o email da empresa.
     *
     * @return {@code String} representando o email da empresa.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email da empresa.
     *
     * @param email {@code String} representando o novo email da empresa.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o telefone da empresa.
     *
     * @return {@code String} representando o telefone da empresa.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone da empresa.
     *
     * @param telefone {@code String} representando o novo telefone da empresa.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obtém a cidade onde a empresa está localizada.
     *
     * @return {@code String} representando a cidade da empresa.
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Define a cidade onde a empresa está localizada.
     *
     * @param cidade {@code String} representando a nova cidade da empresa.
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * Obtém a província onde a empresa está localizada.
     *
     * @return {@code String} representando a província da empresa.
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Define a província onde a empresa está localizada.
     *
     * @param provincia {@code String} representando a nova província da empresa.
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Obtém a data de fundação da empresa.
     *
     * @return {@code Date} representando a data de fundação da empresa.
     */
    public Date getData_fundacao() {
        return data_fundacao;
    }

    /**
     * Define a data de fundação da empresa.
     *
     * @param data_fundacao {@code Date} representando a nova data de fundação da empresa.
     */
    public void setData_fundacao(Date data_fundacao) {
        this.data_fundacao = data_fundacao;
    }

    /**
     * Obtém a cédula jurídica da empresa.
     *
     * @return {@code String} representando a cédula jurídica da empresa.
     */
    public String getCedula_juridica() {
        return cedula_juridica;
    }

    /**
     * Define a cédula jurídica da empresa.
     *
     * @param cedula_juridica {@code String} representando a nova cédula jurídica da empresa.
     */
    public void setCedula_juridica(String cedula_juridica) {
        this.cedula_juridica = cedula_juridica;
    }

    /**
     * Obtém o setor de atuação da empresa.
     *
     * @return {@code String} representando o setor de atuação da empresa.
     */
    public String getSetor() {
        return setor;
    }

    /**
     * Define o setor de atuação da empresa.
     *
     * @param setor {@code String} representando o novo setor de atuação da empresa.
     */
    public void setSetor(String setor) {
        this.setor = setor;
    }

    /**
     * Obtém o número da licença da empresa.
     *
     * @return {@code String} representando o número da licença da empresa.
     */
    public String getNumero_licenca() {
        return numero_licenca;
    }

    /**
     * Define o número da licença da empresa.
     *
     * @param numero_licenca {@code String} representando o novo número da licença da empresa.
     */
    public void setNumero_licenca(String numero_licenca) {
        this.numero_licenca = numero_licenca;
    }

    /**
     * Obtém a rua do endereço da empresa.
     *
     * @return {@code String} representando a rua do endereço da empresa.
     */
    public String getRua() {
        return rua;
    }

    /**
     * Define a rua do endereço da empresa.
     *
     * @param rua {@code String} representando a nova rua do endereço da empresa.
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * Obtém o bairro do endereço da empresa.
     *
     * @return {@code String} representando o bairro do endereço da empresa.
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Define o bairro do endereço da empresa.
     *
     * @param bairro {@code String} representando o novo bairro do endereço da empresa.
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * Obtém o cantão onde a empresa está localizada.
     *
     * @return {@code String} representando o cantão da empresa.
     */
    public String getCanton() {
        return canton;
    }

    /**
     * Define o cantão onde a empresa está localizada.
     *
     * @param canton {@code String} representando o novo cantão da empresa.
     */
    public void setCanton(String canton) {
        this.canton = canton;
    }

    /**
     * Obtém o distrito onde a empresa está localizada.
     *
     * @return {@code String} representando o distrito da empresa.
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     * Define o distrito onde a empresa está localizada.
     *
     * @param distrito {@code String} representando o novo distrito da empresa.
     */
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    /**
     * Obtém o código postal do endereço da empresa.
     *
     * @return {@code int} representando o código postal da empresa.
     */
    public int getCodigo_postal() {
        return codigo_postal;
    }

    /**
     * Define o código postal do endereço da empresa.
     *
     * @param codigo_postal {@code int} representando o novo código postal da empresa.
     */
    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    /**
     * Obtém o complemento do endereço da empresa.
     *
     * @return {@code String} representando o complemento do endereço da empresa.
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * Define o complemento do endereço da empresa.
     *
     * @param complemento {@code String} representando o novo complemento do endereço da empresa.
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
