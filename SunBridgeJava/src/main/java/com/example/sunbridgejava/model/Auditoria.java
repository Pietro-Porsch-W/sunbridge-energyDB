package com.example.sunbridgejava.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Representa uma auditoria de operações no sistema.
 */
@Entity
@Table(name = "auditoria")
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auditoriaID;

    @Column(length = 50, nullable = false)
    private String tabela;

    @Column(length = 10, nullable = false)
    private String operacao;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(length = 60)
    private String usuario;

    @Column(name = "chave_primaria", length = 255)
    private String chavePrimaria;

    @Column(name = "dados_anteriores", columnDefinition = "jsonb")
    private String dadosAnteriores;

    @Column(name = "dados_novos", columnDefinition = "jsonb")
    private String dadosNovos;

    // Construtor padrão
    public Auditoria() {}

    // Construtor completo
    public Auditoria(String tabela, String operacao, LocalDateTime dataHora, String usuario,
                     String chavePrimaria, String dadosAnteriores, String dadosNovos) {
        this.tabela = tabela;
        this.operacao = operacao;
        this.dataHora = dataHora;
        this.usuario = usuario;
        this.chavePrimaria = chavePrimaria;
        this.dadosAnteriores = dadosAnteriores;
        this.dadosNovos = dadosNovos;
    }

    // Getters e Setters
    public int getAuditoriaID() {
        return auditoriaID;
    }

    public void setAuditoriaID(int auditoriaID) {
        this.auditoriaID = auditoriaID;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getChavePrimaria() {
        return chavePrimaria;
    }

    public void setChavePrimaria(String chavePrimaria) {
        this.chavePrimaria = chavePrimaria;
    }

    public String getDadosAnteriores() {
        return dadosAnteriores;
    }

    public void setDadosAnteriores(String dadosAnteriores) {
        this.dadosAnteriores = dadosAnteriores;
    }

    public String getDadosNovos() {
        return dadosNovos;
    }

    public void setDadosNovos(String dadosNovos) {
        this.dadosNovos = dadosNovos;
    }
}
