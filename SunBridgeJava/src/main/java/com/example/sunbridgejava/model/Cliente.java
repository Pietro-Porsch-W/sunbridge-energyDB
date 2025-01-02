package com.example.sunbridgejava.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Entidade que representa um {@link Cliente} no sistema.
 * 
 * <p>
 * Esta classe é mapeada para uma tabela no banco de dados e contém informações detalhadas sobre cada cliente,
 * incluindo dados pessoais, endereço, status de atividade e descrições adicionais.
 * </p>
 * 
 * <p>
 * A entidade possui um relacionamento {@link ManyToOne} com a entidade {@link Usuario}, representando o usuário 
 * associado a este cliente.
 * </p>
 * 
 * <p>
 * As anotações JPA são utilizadas para definir o mapeamento da entidade para a tabela correspondente no banco de dados,
 * bem como as restrições e características de cada coluna.
 * </p>
 * 
 * @author 
 * @version 1.0
 * @since 2024-04-27
 */
@Entity
public class Cliente {

    /**
     * Identificador único do cliente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clienteID;

    /**
     * Usuário associado ao cliente.
     */
    @ManyToOne
    @JoinColumn(name = "usuarioID", nullable = false)
    private Usuario usuarioID;

    /**
     * Cédula do cliente.
     */
    @Column(length = 12, nullable = false)
    private String cedula;

    /**
     * Nome completo do cliente.
     */
    @Column(length = 40, nullable = false)
    private String nome;

    /**
     * Data de nascimento do cliente.
     */
    @Column(nullable = true)
    private LocalDate data_nascimento;

    /**
     * Gênero do cliente.
     */
    @Column(length = 1, nullable = true)
    private Character genero;

    /**
     * Email do cliente.
     */
    @Column(length = 60, nullable = true, unique = true)
    private String email;

    /**
     * Telefone do cliente.
     */
    @Column(length = 20, nullable = true)
    private String telefone;

    /**
     * Rua do endereço do cliente.
     */
    @Column(length = 60, nullable = false)
    private String rua;

    /**
     * Bairro do endereço do cliente.
     */
    @Column(length = 60, nullable = false)
    private String bairro;

    /**
     * Cidade do endereço do cliente.
     */
    @Column(length = 50, nullable = false)
    private String cidade;

    /**
     * Província do endereço do cliente.
     */
    @Column(length = 50, nullable = false)
    private String provincia;

    /**
     * Cantão do endereço do cliente.
     */
    @Column(length = 50, nullable = false)
    private String canton;

    /**
     * Distrito do endereço do cliente.
     */
    @Column(length = 50, nullable = false)
    private String distrito;

    /**
     * Código postal do endereço do cliente.
     */
    @Column(nullable = false)
    private int codigo_postal;

    /**
     * Complemento do endereço do cliente.
     */
    @Column(length = 60)
    private String complemento;

    /**
     * Dívida pendente do cliente.
     */
    @Column
    private Double divida;

    /**
     * Construtor completo da classe {@link Cliente}.
     *
     * @param bairro           Bairro do endereço do cliente.
     * @param canton           Cantão do endereço do cliente.
     * @param cedula           Cédula do cliente.
     * @param cidade           Cidade do endereço do cliente.
     * @param clienteID        Identificador único do cliente.
     * @param codigo_postal    Código postal do endereço do cliente.
     * @param complemento      Complemento do endereço do cliente.
     * @param data_nascimento  Data de nascimento do cliente.
     * @param distrito         Distrito do endereço do cliente.
     * @param divida           Dívida pendente do cliente.
     * @param email            Email do cliente.
     * @param genero           Gênero do cliente.
     * @param nome             Nome completo do cliente.
     * @param provincia        Província do endereço do cliente.
     * @param rua              Rua do endereço do cliente.
     * @param telefone         Telefone do cliente.
     * @param usuarioID        Usuário associado ao cliente.
     */
    public Cliente(String bairro, String canton, String cedula, String cidade, int clienteID, int codigo_postal,
                   String complemento, LocalDate data_nascimento, String distrito, Double divida, String email,
                   Character genero, String nome, String provincia, String rua, String telefone, Usuario usuarioID) {
        this.bairro = bairro;
        this.canton = canton;
        this.cedula = cedula;
        this.cidade = cidade;
        this.clienteID = clienteID;
        this.codigo_postal = codigo_postal;
        this.complemento = complemento;
        this.data_nascimento = data_nascimento;
        this.distrito = distrito;
        this.divida = divida;
        this.email = email;
        this.genero = genero;
        this.nome = nome;
        this.provincia = provincia;
        this.rua = rua;
        this.telefone = telefone;
        this.usuarioID = usuarioID;
    }

    /**
     * Construtor padrão da classe {@link Cliente}.
     */
    public Cliente() {

    }

    /**
     * Obtém o identificador único do cliente.
     *
     * @return {@code int} representando o ID do cliente.
     */
    public int getClienteID() {
        return clienteID;
    }

    /**
     * Define o identificador único do cliente.
     *
     * @param clienteID {@code int} representando o novo ID do cliente.
     */
    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    /**
     * Obtém o usuário associado ao cliente.
     *
     * @return {@link Usuario} representando o usuário associado.
     */
    public Usuario getUsuarioID() {
        return usuarioID;
    }

    /**
     * Define o usuário associado ao cliente.
     *
     * @param usuarioID {@link Usuario} representando o novo usuário associado.
     */
    public void setUsuarioID(Usuario usuarioID) {
        this.usuarioID = usuarioID;
    }

    /**
     * Obtém a cédula do cliente.
     *
     * @return {@code String} representando a cédula do cliente.
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Define a cédula do cliente.
     *
     * @param cedula {@code String} representando a nova cédula do cliente.
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtém o nome completo do cliente.
     *
     * @return {@code String} representando o nome completo do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome completo do cliente.
     *
     * @param nome {@code String} representando o novo nome completo do cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a data de nascimento do cliente.
     *
     * @return {@code LocalDate} representando a data de nascimento do cliente.
     */
    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    /**
     * Define a data de nascimento do cliente.
     *
     * @param data_nascimento {@code LocalDate} representando a nova data de nascimento do cliente.
     */
    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    /**
     * Obtém o gênero do cliente.
     *
     * @return {@code Character} representando o gênero do cliente.
     */
    public Character getGenero() {
        return genero;
    }

    /**
     * Define o gênero do cliente.
     *
     * @param genero {@code Character} representando o novo gênero do cliente.
     */
    public void setGenero(Character genero) {
        this.genero = genero;
    }

    /**
     * Obtém o email do cliente.
     *
     * @return {@code String} representando o email do cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do cliente.
     *
     * @param email {@code String} representando o novo email do cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o telefone do cliente.
     *
     * @return {@code String} representando o telefone do cliente.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do cliente.
     *
     * @param telefone {@code String} representando o novo telefone do cliente.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obtém a rua do endereço do cliente.
     *
     * @return {@code String} representando a rua do endereço do cliente.
     */
    public String getRua() {
        return rua;
    }

    /**
     * Define a rua do endereço do cliente.
     *
     * @param rua {@code String} representando a nova rua do endereço do cliente.
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * Obtém o bairro do endereço do cliente.
     *
     * @return {@code String} representando o bairro do endereço do cliente.
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Define o bairro do endereço do cliente.
     *
     * @param bairro {@code String} representando o novo bairro do endereço do cliente.
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * Obtém a cidade do endereço do cliente.
     *
     * @return {@code String} representando a cidade do endereço do cliente.
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Define a cidade do endereço do cliente.
     *
     * @param cidade {@code String} representando a nova cidade do endereço do cliente.
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * Obtém a província do endereço do cliente.
     *
     * @return {@code String} representando a província do endereço do cliente.
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Define a província do endereço do cliente.
     *
     * @param provincia {@code String} representando a nova província do endereço do cliente.
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Obtém o cantão do endereço do cliente.
     *
     * @return {@code String} representando o cantão do endereço do cliente.
     */
    public String getCanton() {
        return canton;
    }

    /**
     * Define o cantão do endereço do cliente.
     *
     * @param canton {@code String} representando o novo cantão do endereço do cliente.
     */
    public void setCanton(String canton) {
        this.canton = canton;
    }

    /**
     * Obtém o distrito do endereço do cliente.
     *
     * @return {@code String} representando o distrito do endereço do cliente.
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     * Define o distrito do endereço do cliente.
     *
     * @param distrito {@code String} representando o novo distrito do endereço do cliente.
     */
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    /**
     * Obtém o código postal do endereço do cliente.
     *
     * @return {@code int} representando o código postal do endereço do cliente.
     */
    public int getCodigo_postal() {
        return codigo_postal;
    }

    /**
     * Define o código postal do endereço do cliente.
     *
     * @param codigo_postal {@code int} representando o novo código postal do endereço do cliente.
     */
    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    /**
     * Obtém o complemento do endereço do cliente.
     *
     * @return {@code String} representando o complemento do endereço do cliente.
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * Define o complemento do endereço do cliente.
     *
     * @param complemento {@code String} representando o novo complemento do endereço do cliente.
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * Obtém a dívida pendente do cliente.
     *
     * @return {@code Double} representando a dívida pendente do cliente.
     */
    public Double getDivida() {
        return divida;
    }

    /**
     * Define a dívida pendente do cliente.
     *
     * @param divida {@code Double} representando a nova dívida pendente do cliente.
     */
    public void setDivida(Double divida) {
        this.divida = divida;
    }
}
