package com.example.sunbridgejava.repository;

import com.example.sunbridgejava.model.Cliente_logistica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório para operações de acesso a dados da entidade {@link Cliente_logistica}.
 * 
 * Extende {@link JpaRepository} para fornecer métodos CRUD padrão e métodos de consulta personalizados.
 */
@Repository
public interface Cliente_logisticaRepository extends JpaRepository<Cliente_logistica, Integer> {

    /**
     * Busca clientes cuja propriedade {@code nome} contém a string especificada.
     *
     * @param nome Parte ou totalidade do nome do cliente a ser buscado.
     * @return Lista de {@link Cliente_logistica} que correspondem ao critério de busca.
     */
    List<Cliente_logistica> findByNomeContainingIgnoreCase(String nome);

    /**
     * Busca clientes cuja propriedade {@code nome} contém a string especificada utilizando uma consulta JPQL personalizada.
     *
     * @param nome Parte ou totalidade do nome do cliente a ser buscado.
     * @return Lista de {@link Cliente_logistica} que correspondem ao critério de busca.
     */
    @Query("SELECT c FROM Cliente_logistica c WHERE c.nome LIKE %:nome%")
    List<Cliente_logistica> buscarClientesPorNome(String nome);
}
