package com.example.sunbridgejava.repository;

import com.example.sunbridgejava.model.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repositório para a entidade {@link Auditoria}.
 */
@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria, Integer> {

    /**
     * Busca auditorias por nome da tabela.
     *
     * @param tabela Nome da tabela auditada.
     * @return Lista de auditorias.
     */
    List<Auditoria> findByTabela(String tabela);

    /**
     * Busca auditorias por operação.
     *
     * @param operacao Tipo de operação realizada (INSERT, UPDATE, DELETE).
     * @return Lista de auditorias.
     */
    List<Auditoria> findByOperacao(String operacao);

    /**
     * Busca registros de auditoria por tabela, campo alterado e intervalo de datas.
     *
     * @param tabela Nome da tabela para filtrar.
     * @param campo Nome do campo alterado.
     * @param dataInicio Data de início do intervalo.
     * @param dataFim Data de término do intervalo.
     * @return Lista de registros de auditoria correspondentes aos critérios.
     */
    @Query("SELECT a FROM Auditoria a " +
            "WHERE a.tabela = :tabela " +
            "AND a.dadosNovos LIKE %:campo% " +
            "AND a.dataHora BETWEEN :dataInicio AND :dataFim")
    List<Auditoria> findByTableFieldAndDateRange(String tabela, String campo, LocalDateTime dataInicio, LocalDateTime dataFim);

    @Query(value = """
        SELECT * 
        FROM auditoria 
        WHERE tabela = :tabela 
          AND data_hora BETWEEN :dataInicio AND :dataFim
          AND CAST(dados_novos AS TEXT) LIKE %:campo%
        """, nativeQuery = true)
    List<Auditoria> findByCampo(
            @Param("tabela") String tabela,
            @Param("campo") String campo,
            @Param("dataInicio") LocalDateTime dataInicio,
            @Param("dataFim") LocalDateTime dataFim
    );
}
