package com.example.sunbridgejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sunbridgejava.model.Pedido_compra;

/**
 * Repositório para operações de acesso a dados da entidade {@link Pedido_compra}.
 * 
 * Extende {@link JpaRepository} para fornecer métodos CRUD padrão e métodos de consulta personalizados.
 * 
 * Aqui você pode adicionar métodos personalizados, se necessário.
 */
@Repository
public interface Pedido_compraRepository extends JpaRepository<Pedido_compra, Integer> {

    /**
     * Método personalizado para buscar pedidos de compra cujo {@code usuarioID} contém a string especificada.
     * 
     * Similar à consulta SQL: {@code LIKE '%usuarioID%'}.
     *
     * @param usuarioID Parte ou totalidade do ID do usuário a ser buscado.
     * @return Lista de {@link Pedido_compra} que correspondem ao critério de busca.
     */
    // List<Pedido_compra> findByUsuarioIDContaining(String usuarioID);
}
