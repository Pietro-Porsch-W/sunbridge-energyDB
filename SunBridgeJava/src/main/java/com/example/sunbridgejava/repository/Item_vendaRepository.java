package com.example.sunbridgejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sunbridgejava.model.Item_venda;

/**
 * Repositório para operações de acesso a dados da entidade {@link Item_venda}.
 * 
 * Extende {@link JpaRepository} para fornecer métodos CRUD padrão e métodos de consulta personalizados.
 */
@Repository
public interface Item_vendaRepository extends JpaRepository<Item_venda, Integer> {

    /**
     * Método personalizado para buscar itens de venda pelo pedido de venda contendo a string especificada.
     *
     * Similar à consulta SQL: {@code LIKE '%ped_venda%'}.
     *
     * @param ped_venda Parte ou totalidade do identificador do pedido de venda a ser buscado.
     * @return Lista de {@link Item_venda} que correspondem ao critério de busca.
     */
    // List<Item_venda> findItem_vendaByPed_vendaContaining(String ped_venda);
}
