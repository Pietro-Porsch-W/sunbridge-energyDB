package com.example.sunbridgejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sunbridgejava.model.Pedido_fornecedor;

/**
 * Repositório para operações de acesso a dados da entidade {@link Pedido_fornecedor}.
 * 
 * Extende {@link JpaRepository} para fornecer métodos CRUD padrão e métodos de consulta personalizados.
 * 
 * Aqui você pode adicionar métodos personalizados, se necessário.
 */
@Repository
public interface Pedido_fornecedorRepository extends JpaRepository<Pedido_fornecedor, Integer> {

    /**
     * Método personalizado para buscar pedidos de fornecedor cujo {@code ped_compra} contém a string especificada.
     * 
     * Similar à consulta SQL: {@code LIKE '%ped_compra%'}.
     *
     * @param ped_compra Parte ou totalidade do identificador do pedido de compra a ser buscado.
     * @return Lista de {@link Pedido_fornecedor} que correspondem ao critério de busca.
     */
    // List<Pedido_fornecedor> findByPedCompraContaining(String ped_compra);
}
