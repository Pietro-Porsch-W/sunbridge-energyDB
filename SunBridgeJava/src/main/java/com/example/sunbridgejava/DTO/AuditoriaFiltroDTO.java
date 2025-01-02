package com.example.sunbridgejava.DTO;

import java.time.LocalDateTime;

/**
 * Classe DTO utilizada para filtrar registros de auditoria com base em critérios específicos.
 */
public class AuditoriaFiltroDTO {
    private String tabela; // Nome da tabela associada à auditoria
    private String campo; // Nome do campo associado à auditoria
    private LocalDateTime dataInicio; // Data e hora de início para o filtro
    private LocalDateTime dataFim; // Data e hora de término para o filtro

    /**
     * Obtém o nome da tabela associada à auditoria.
     *
     * @return o nome da tabela.
     */
    public String getTabela() {
        return tabela;
    }

    /**
     * Define o nome da tabela associada à auditoria.
     *
     * @param tabela o nome da tabela.
     */
    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    /**
     * Obtém o nome do campo associado à auditoria.
     *
     * @return o nome do campo.
     */
    public String getCampo() {
        return campo;
    }

    /**
     * Define o nome do campo associado à auditoria.
     *
     * @param campo o nome do campo.
     */
    public void setCampo(String campo) {
        this.campo = campo;
    }

    /**
     * Obtém a data e hora de início para o filtro de auditoria.
     *
     * @return a data e hora de início.
     */
    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    /**
     * Define a data e hora de início para o filtro de auditoria.
     *
     * @param dataInicio a data e hora de início.
     */
    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * Obtém a data e hora de término para o filtro de auditoria.
     *
     * @return a data e hora de término.
     */
    public LocalDateTime getDataFim() {
        return dataFim;
    }

    /**
     * Define a data e hora de término para o filtro de auditoria.
     *
     * @param dataFim a data e hora de término.
     */
    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }
}
