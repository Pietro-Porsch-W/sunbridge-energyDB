package com.example.sunbridgejava.repository;

import java.sql.Date;
import java.util.List;

import com.example.sunbridgejava.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.sunbridgejava.model.Pedido_venda;

/**
 * Repositório para operações de acesso a dados da entidade {@link Pedido_venda}.
 * 
 * Extende {@link JpaRepository} para fornecer métodos CRUD padrão e métodos de consulta personalizados.
 * 
 * Aqui você pode adicionar métodos personalizados, se necessário.
 */
@Repository
public interface Pedido_vendaRepository extends JpaRepository<Pedido_venda, Integer> {

    /**
     * Método personalizado para buscar pedidos de venda cujo {@code clienteID} contém a string especificada.
     * 
     * Similar à consulta SQL: {@code LIKE '%clienteID%'}.
     *
     * @param id Parte ou totalidade do ID do cliente a ser buscado.
     * @return Lista de {@link Pedido_venda} que correspondem ao critério de busca.
     */
    List<Pedido_venda> findByclienteID(Cliente id);


    @Query("SELECT p FROM Pedido_venda p WHERE p.data_venda BETWEEN :inicio AND :fim")
    List<Pedido_venda> buscarPorPeriodo(@Param("inicio") Date inicio, @Param("fim") Date fim);

}
