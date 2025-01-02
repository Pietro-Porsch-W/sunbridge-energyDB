package com.example.sunbridgejava.repository;

import com.example.sunbridgejava.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para operações de acesso a dados da entidade {@link Estoque}.
 * 
 * Extende {@link JpaRepository} para fornecer métodos CRUD padrão e métodos de consulta personalizados.
 */
@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {

    /**
     * Busca estoques cuja propriedade {@code descricao} contém a string especificada.
     * 
     * Similar à consulta SQL: {@code LIKE '%descricao%'}.
     *
     * @param descricao Parte ou totalidade da descrição do estoque a ser buscada.
     * @return Lista de {@link Estoque} que correspondem ao critério de busca.
     */
    // @Query("SELECT e FROM Estoque e WHERE e.descricao LIKE %:descricao%")
    // List<Estoque> buscarPorDescricao(String descricao);
}
