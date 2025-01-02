package com.example.sunbridgejava.controller;

import com.example.sunbridgejava.DTO.AuditoriaFiltroDTO;
import com.example.sunbridgejava.model.Auditoria;
import com.example.sunbridgejava.service.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Controlador REST para operações relacionadas à entidade {@link Auditoria}.
 */
@RestController
@RequestMapping("/auditoria")
public class AuditoriaController {

    @Autowired
    private AuditoriaService s;

    /**
     * Obtém todas as auditorias.
     * 
     * @return Lista de auditorias.
     */
    @GetMapping("/find/all")
    public ResponseEntity<List<Auditoria>> findAll() {
        return ResponseEntity.ok(s.findAll());
    }

    /**
     * Busca auditorias por tabela.
     * 
     * @param tabela Nome da tabela auditada.
     * @return Lista de auditorias.
     */
    @GetMapping("/find/tabela/{tabela}")
    public ResponseEntity<List<Auditoria>> findByTabela(@PathVariable String tabela) {
        return ResponseEntity.ok(s.findByTabela(tabela));
    }

    /**
     * Pesquisa auditorias por tabela, campo alterado e intervalo de datas.
     *
     * @param filtro Objeto contendo os parâmetros de busca: tabela, campo, dataInicio e dataFim.
     * @return Lista de registros de auditoria correspondentes aos critérios de pesquisa.
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/find/campo")
    public ResponseEntity<?> findByCampo(@RequestBody AuditoriaFiltroDTO filtro) {
        try {
            List<Auditoria> resultados = s.findByCampo(
                    filtro.getTabela(),
                    filtro.getCampo(),
                    filtro.getDataInicio(),
                    filtro.getDataFim()
            );
            return ResponseEntity.ok(resultados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
        }
    }

    /**
     * Classe auxiliar para receber os parâmetros de busca.
     */
    public static class SearchParams {
        private String tabela;
        private String campo;
        private LocalDateTime dataInicio;
        private LocalDateTime dataFim;

        // Getters e Setters
        public String getTabela() {
            return tabela;
        }

        public void setTabela(String tabela) {
            this.tabela = tabela;
        }

        public String getCampo() {
            return campo;
        }

        public void setCampo(String campo) {
            this.campo = campo;
        }

        public LocalDateTime getDataInicio() {
            return dataInicio;
        }

        public void setDataInicio(LocalDateTime dataInicio) {
            this.dataInicio = dataInicio;
        }

        public LocalDateTime getDataFim() {
            return dataFim;
        }

        public void setDataFim(LocalDateTime dataFim) {
            this.dataFim = dataFim;
        }
    }


}
