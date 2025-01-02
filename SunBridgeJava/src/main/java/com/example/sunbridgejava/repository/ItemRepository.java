package com.example.sunbridgejava.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sunbridgejava.model.Item;

/**
 * Repositório para operações de acesso a dados da entidade {@link Item}.
 * 
 * Extende {@link JpaRepository} para fornecer métodos CRUD padrão e métodos de consulta personalizados.
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    /**
     * Busca itens cuja propriedade {@code nome} contém a string especificada.
     * 
     * Similar à consulta SQL: {@code LIKE '%nome%'}.
     *
     * @param nome Parte ou totalidade do nome do item a ser buscado.
     * @return Lista de {@link Item} que correspondem ao critério de busca.
     */
    List<Item> findByNomeContaining(String nome);
}
