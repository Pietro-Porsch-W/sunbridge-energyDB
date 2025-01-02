package com.example.sunbridgejava.model;

import jakarta.persistence.*;
import java.sql.Date;

/**
 * Representa um usuário no sistema.
 * 
 * <p>
 * A entidade {@code Usuario} armazena as informações de um usuário, incluindo
 * dados pessoais, credenciais, informações de endereço e associação com uma
 * empresa ou outro usuário. Os relacionamentos JPA gerenciam as conexões
 * entre esta classe e outras entidades, como {@link Empresa}.
 * </p>
 * 
 * @version 1.0
 * @since 2024-04-27
 */
@Entity
@Table(name = "usuario")
public class Usuario {

    /**
     * Identificador único do usuário.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuarioID;

    /**
     * Usuário associado como chave estrangeira.
     */
    @ManyToOne
    @JoinColumn(name = "usuarioID_FK")
    private Usuario usuarioID_FK;

    /**
     * Empresa associada ao usuário.
     */
    @ManyToOne
    @JoinColumn(name = "companyID", nullable = false)
    private Empresa companyID;

    /**
     * Nome do usuário.
     */
    @Column(length = 40, nullable = false)
    private String nome;

    /**
     * Gênero do usuário.
     */
    @Column(length = 1, nullable = false)
    private char genero;

    /**
     * Data de entrada do usuário no sistema.
     */
    @Column
    private Date data_entrada;

    /**
     * Tipo do usuário, representado por um inteiro.
     */
    @Column
    private Integer tipo;

    /**
     * Cédula do usuário.
     */
    @Column(length = 15)
    private String cedula;

    /**
     * Data de nascimento do usuário.
     */
    @Column
    private Date data_nascimento;

    /**
     * Departamento ao qual o usuário pertence.
     */
    @Column(length = 100, nullable = false)
    private String departamento;

    /**
     * Data de admissão do usuário na empresa.
     */
    @Column(nullable = false)
    private Date data_admissao;

    /**
     * Salário do usuário.
     */
    @Column
    private double salario;

    /**
     * Status ativo/inativo do usuário.
     */
    @Column(nullable = false)
    private Boolean ativo;

    /**
     * Telefone do usuário.
     */
    @Column(length = 20)
    private String telefone;

    /**
     * Email do usuário.
     */
    @Column(length = 60, nullable = false, unique = true)
    private String email;

    /**
     * Senha do usuário.
     */
    @Column(nullable = false)
    private String senha;

    /**
     * Rua do endereço do usuário.
     */
    @Column(length = 60, nullable = false)
    private String rua;

    /**
     * Bairro do endereço do usuário.
     */
    @Column(length = 60, nullable = false)
    private String bairro;

    /**
     * Cidade onde o usuário reside.
     */
    @Column(length = 50, nullable = false)
    private String cidade;

    /**
     * Cantão onde o usuário reside.
     */
    @Column(length = 50, nullable = false)
    private String canton;

    /**
     * Distrito onde o usuário reside.
     */
    @Column(length = 50, nullable = false)
    private String distrito;

    /**
     * Código postal do endereço do usuário.
     */
    @Column(nullable = false)
    private int codigo_postal;

    /**
     * Complemento do endereço do usuário.
     */
    @Column(length = 60)
    private String complemento;

    /**
     * Construtor padrão da classe {@code Usuario}.
     */
    public Usuario() {}

    /**
     * Construtor completo da classe {@code Usuario}.
     * 
     * @param usuarioID       Identificador único do usuário.
     * @param usuarioID_FK    Usuário associado.
     * @param companyID       Empresa associada ao usuário.
     * @param nome            Nome do usuário.
     * @param genero          Gênero do usuário.
     * @param data_entrada    Data de entrada do usuário no sistema.
     * @param tipo            Tipo do usuário.
     * @param cedula          Cédula do usuário.
     * @param data_nascimento Data de nascimento do usuário.
     * @param departamento    Departamento do usuário.
     * @param data_admissao   Data de admissão do usuário.
     * @param salario         Salário do usuário.
     * @param ativo           Status ativo/inativo do usuário.
     * @param telefone        Telefone do usuário.
     * @param email           Email do usuário.
     * @param senha           Senha do usuário.
     * @param rua             Rua do endereço do usuário.
     * @param bairro          Bairro do endereço do usuário.
     * @param cidade          Cidade do usuário.
     * @param canton          Cantão do usuário.
     * @param distrito        Distrito do usuário.
     * @param codigo_postal   Código postal do usuário.
     * @param complemento     Complemento do endereço do usuário.
     */
    public Usuario(int usuarioID, Usuario usuarioID_FK, Empresa companyID, String nome, char genero, Date data_entrada,
                   Integer tipo, String cedula, Date data_nascimento, String departamento, Date data_admissao,
                   double salario, Boolean ativo, String telefone, String email, String senha, String rua,
                   String bairro, String cidade, String canton, String distrito, int codigo_postal, String complemento) {
        this.usuarioID = usuarioID;
        this.usuarioID_FK = usuarioID_FK;
        this.companyID = companyID;
        this.nome = nome;
        this.genero = genero;
        this.data_entrada = data_entrada;
        this.tipo = tipo;
        this.cedula = cedula;
        this.data_nascimento = data_nascimento;
        this.departamento = departamento;
        this.data_admissao = data_admissao;
        this.salario = salario;
        this.ativo = ativo;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.canton = canton;
        this.distrito = distrito;
        this.codigo_postal = codigo_postal;
        this.complemento = complemento;
    }

    // Getters e Setters

    /**
     * Obtém o ID do usuário.
     * 
     * @return ID do usuário.
     */
    public int getUsuarioID() {
        return usuarioID;
    }

    /**
     * Define o ID do usuário.
     * 
     * @param usuarioID ID do usuário.
     */
    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    /**
     * Obtém o usuário associado.
     * 
     * @return Usuário associado.
     */
    public Usuario getUsuarioID_FK() {
        return usuarioID_FK;
    }

    /**
     * Define o usuário associado.
     * 
     * @param usuarioID_FK Usuário associado.
     */
    public void setUsuarioID_FK(Usuario usuarioID_FK) {
        this.usuarioID_FK = usuarioID_FK;
    }

    /**
     * Obtém a empresa associada ao usuário.
     * 
     * @return Empresa associada ao usuário.
     */
    public Empresa getCompanyID() {
        return companyID;
    }

    /**
     * Define a empresa associada ao usuário.
     * 
     * @param companyID Empresa associada ao usuário.
     */
    public void setCompanyID(Empresa companyID) {
        this.companyID = companyID;
    }

    /**
     * Obtém o nome do usuário.
     * 
     * @return Nome do usuário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuário.
     * 
     * @param nome Nome do usuário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o gênero do usuário.
     * 
     * @return Gênero do usuário.
     */
    public char getGenero() {
        return genero;
    }

    /**
     * Define o gênero do usuário.
     * 
     * @param genero Gênero do usuário.
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }

    /**
     * Obtém a data de entrada do usuário no sistema.
     * 
     * @return Data de entrada do usuário no sistema.
     */
    public Date getData_entrada() {
        return data_entrada;
    }

    /**
     * Define a data de entrada do usuário no sistema.
     * 
     * @param data_entrada Data de entrada do usuário no sistema.
     */
    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    /**
     * Obtém o tipo do usuário.
     * 
     * @return Tipo do usuário.
     */
    public Integer getTipo() {
        return tipo;
    }

    /**
     * Define o tipo do usuário.
     * 
     * @param tipo Tipo do usuário.
     */
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtém a cédula do usuário.
     * 
     * @return Cédula do usuário.
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Define a cédula do usuário.
     * 
     * @param cedula Cédula do usuário.
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtém a data de nascimento do usuário.
     * 
     * @return Data de nascimento do usuário.
     */
    public Date getData_nascimento() {
        return data_nascimento;
    }

    /**
     * Define a data de nascimento do usuário.
     * 
     * @param data_nascimento Data de nascimento do usuário.
     */
    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    /**
     * Obtém o departamento do usuário.
     * 
     * @return Departamento do usuário.
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Define o departamento do usuário.
     * 
     * @param departamento Departamento do usuário.
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Obtém a data de admissão do usuário na empresa.
     * 
     * @return Data de admissão do usuário.
     */
    public Date getData_admissao() {
        return data_admissao;
    }

    /**
     * Define a data de admissão do usuário na empresa.
     * 
     * @param data_admissao Data de admissão do usuário.
     */
    public void setData_admissao(Date data_admissao) {
        this.data_admissao = data_admissao;
    }

    /**
     * Obtém o salário do usuário.
     * 
     * @return Salário do usuário.
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Define o salário do usuário.
     * 
     * @param salario Salário do usuário.
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Obtém o status ativo/inativo do usuário.
     * 
     * @return Status ativo/inativo do usuário.
     */
    public Boolean getAtivo() {
        return ativo;
    }

    /**
     * Define o status ativo/inativo do usuário.
     * 
     * @param ativo Status ativo/inativo do usuário.
     */
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * Obtém o telefone do usuário.
     * 
     * @return Telefone do usuário.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do usuário.
     * 
     * @param telefone Telefone do usuário.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obtém o email do usuário.
     * 
     * @return Email do usuário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do usuário.
     * 
     * @param email Email do usuário.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém a senha do usuário.
     * 
     * @return Senha do usuário.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do usuário.
     * 
     * @param senha Senha do usuário.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Obtém a rua do endereço do usuário.
     * 
     * @return Rua do endereço do usuário.
     */
    public String getRua() {
        return rua;
    }

    /**
     * Define a rua do endereço do usuário.
     * 
     * @param rua Rua do endereço do usuário.
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * Obtém o bairro do endereço do usuário.
     * 
     * @return Bairro do endereço do usuário.
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Define o bairro do endereço do usuário.
     * 
     * @param bairro Bairro do endereço do usuário.
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * Obtém a cidade onde o usuário reside.
     * 
     * @return Cidade onde o usuário reside.
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Define a cidade onde o usuário reside.
     * 
     * @param cidade Cidade onde o usuário reside.
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * Obtém o cantão onde o usuário reside.
     * 
     * @return Cantão onde o usuário reside.
     */
    public String getCanton() {
        return canton;
    }

    /**
     * Define o cantão onde o usuário reside.
     * 
     * @param canton Cantão onde o usuário reside.
     */
    public void setCanton(String canton) {
        this.canton = canton;
    }

    /**
     * Obtém o distrito onde o usuário reside.
     * 
     * @return Distrito onde o usuário reside.
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     * Define o distrito onde o usuário reside.
     * 
     * @param distrito Distrito onde o usuário reside.
     */
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    /**
     * Obtém o código postal do endereço do usuário.
     * 
     * @return Código postal do endereço do usuário.
     */
    public int getCodigo_postal() {
        return codigo_postal;
    }

    /**
     * Define o código postal do endereço do usuário.
     * 
     * @param codigo_postal Código postal do endereço do usuário.
     */
    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    /**
     * Obtém o complemento do endereço do usuário.
     * 
     * @return Complemento do endereço do usuário.
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * Define o complemento do endereço do usuário.
     * 
     * @param complemento Complemento do endereço do usuário.
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
