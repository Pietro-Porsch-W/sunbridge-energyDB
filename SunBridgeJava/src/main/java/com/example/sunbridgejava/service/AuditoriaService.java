package com.example.sunbridgejava.service;

import com.example.sunbridgejava.model.Auditoria;
import com.example.sunbridgejava.repository.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Serviço para manipular dados de auditoria.
 */
@Service
public class AuditoriaService {

    @Autowired
    private AuditoriaRepository r;

    /**
     * Retorna todas as auditorias.
     * 
     * @return Lista de auditorias.
     */
    public List<Auditoria> findAll() {
        System.out.println("Procura de auditoria de todas as informações");
        return r.findAll();
    }

    /**
     * Busca auditorias por tabela.
     * 
     * @param tabela Nome da tabela.
     * @return Lista de auditorias.
     */
    public List<Auditoria> findByTabela(String tabela) {
        System.out.println("Procura de auditoria pela tabela: " + tabela);
        return r.findByTabela(tabela);
    }

    /**
     * Busca registros de auditoria por tabela, campo alterado e intervalo de datas.
     *
     * @param tabela Nome da tabela para filtrar.
     * @param campo Nome do campo alterado.
     * @param dataInicio Data de início do intervalo.
     * @param dataFim Data de término do intervalo.
     * @return Lista de registros de auditoria correspondentes aos critérios.
     */

    public List<Auditoria> findByCampo(String tabela, String campo, LocalDateTime dataInicio, LocalDateTime dataFim) {
        System.out.println("Procura de auditoria pela tabela: " + tabela + " pelo campo: " + campo + " dataInicio: " + dataInicio + " dataFim: " + dataFim);

        return r.findByCampo(tabela, campo, dataInicio, dataFim);
    }

}
