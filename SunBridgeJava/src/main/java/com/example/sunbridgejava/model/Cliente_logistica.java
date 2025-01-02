package com.example.sunbridgejava.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Classe que representa o modelo {@link Cliente_logistica}.
 * 
 * Esta entidade mapeia os dados relacionados à logística de um cliente, incluindo informações pessoais
 * e detalhes de endereço. Está associada a um {@link Pedido_venda} através de uma relação unidirecional.
 */
@Entity
@Table(name = "cliente_logistica")
public class Cliente_logistica {
    /**
     * Identificador único da logística.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer logisticalID;
    
    /**
     * Pedido de venda associado.
     */
    @OneToOne
    @JoinColumn(name = "ped_venda", nullable = false)
    private Pedido_venda ped_venda;

    /**
     * Cédula do cliente.
     */
    @Column(length = 12)
    private String cedula;

    /**
     * Data de entrega.
     */
    @Column(nullable = false)
    private java.sql.Date data_entrega;

    /**
     * Nome do cliente.
     */
    @Column(length = 40, nullable = false)
    private String nome;

    /**
     * Gênero do cliente.
     */
    @Column(length = 1, nullable = false)
    private char genero;

    /**
     * Data de nascimento do cliente.
     */
    @Column
    private java.sql.Date data_nascimento;
    
    /**
     * Email do cliente.
     */
    @Column(length = 60, nullable = false, unique = true)
    private String email;
    
    /**
     * Telefone do cliente.
     */
    @Column(length = 20, nullable = false)
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
    @Column(length = 10, nullable = false)
    private int codigo_postal;
    
    /**
     * Complemento do endereço do cliente.
     */
    @Column(length = 60, nullable = false)
    private String complemento;

    /**
     * Construtor completo da classe {@link Cliente_logistica}.
     *
     * @param logisticalID     Identificador único da logística.
     * @param ped_venda       Pedido de venda associado.
     * @param cedula          Cédula do cliente.
     * @param data_entrega    Data de entrega.
     * @param nome            Nome do cliente.
     * @param data_nascimento Data de nascimento do cliente.
     * @param genero          Gênero do cliente.
     * @param email           Email do cliente.
     * @param telefone        Telefone do cliente.
     * @param rua             Rua do endereço do cliente.
     * @param bairro          Bairro do endereço do cliente.
     * @param cidade          Cidade do endereço do cliente.
     * @param provincia       Província do endereço do cliente.
     * @param canton          Cantão do endereço do cliente.
     * @param distrito        Distrito do endereço do cliente.
     * @param codigo_postal   Código postal do endereço do cliente.
     * @param complemento     Complemento do endereço do cliente.
     */
    public Cliente_logistica(Integer logisticalID, Pedido_venda ped_venda, String cedula, Date data_entrega, String nome, Date data_nascimento,
                   char genero, String email, String telefone, String rua, String bairro,
                   String cidade, String provincia, String canton, String distrito, int codigo_postal, String complemento) {
        this.logisticalID = logisticalID;
        this.ped_venda = ped_venda;
        this.cedula = cedula;
        this.data_entrega = data_entrega;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.genero = genero;
        this.email = email;
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
     * Construtor padrão da classe {@link Cliente_logistica}.
     */
    public Cliente_logistica() {

    }

    /**
     * Obtém o identificador único da logística.
     *
<<<<<<< Updated upstream
     * @return logisticalID
=======
     * @return {@code Integer} representando o ID da logística.
>>>>>>> Stashed changes
     */
    public Integer getLogisticaID() {
        return logisticalID;
    }

    /**
     * Define o identificador único da logística.
     *
<<<<<<< Updated upstream
     * @param logisticalID Identificador único da logística.
=======
     * @param logisticaID {@code Integer} representando o novo ID da logística.
>>>>>>> Stashed changes
     */
    public void setLogisticaID(Integer logisticalID) {
        this.logisticalID = logisticalID;
    }

    /**
     * Obtém o pedido de venda associado.
     *
     * @return {@link Pedido_venda} representando o pedido de venda.
     */
    public Pedido_venda getPed_venda() {
        return ped_venda;
    }

    /**
     * Define o pedido de venda associado.
     *
     * @param ped_venda {@link Pedido_venda} representando o novo pedido de venda.
     */
    public void setPed_venda(Pedido_venda ped_venda) {
        this.ped_venda = ped_venda;
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
     * Obtém a data de entrega.
     *
     * @return {@code Date} representando a data de entrega.
     */
    public Date getData_entrega() {
        return data_entrega;
    }

    /**
     * Define a data de entrega.
     *
     * @param data_entrega {@code Date} representando a nova data de entrega.
     */
    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }

    /**
     * Obtém o nome do cliente.
     *
     * @return {@code String} representando o nome do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do cliente.
     *
     * @param nome {@code String} representando o novo nome do cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o gênero do cliente.
     *
     * @return {@code char} representando o gênero do cliente.
     */
    public char getGenero() {
        return genero;
    }

    /**
     * Define o gênero do cliente.
     *
     * @param genero {@code char} representando o novo gênero do cliente.
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }

    /**
     * Obtém a data de nascimento do cliente.
     *
     * @return {@code Date} representando a data de nascimento do cliente.
     */
    public Date getData_nascimento() {
        return data_nascimento;
    }

    /**
     * Define a data de nascimento do cliente.
     *
     * @param data_nascimento {@code Date} representando a nova data de nascimento do cliente.
     */
    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
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
     * @return {@code String} representando o código postal do endereço do cliente.
     */
    public int getCodigo_postal() {
        return codigo_postal;
    }

    /**
     * Define o código postal do endereço do cliente.
     *
     * @param codigo_postal {@code String} representando o novo código postal do endereço do cliente.
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
}
