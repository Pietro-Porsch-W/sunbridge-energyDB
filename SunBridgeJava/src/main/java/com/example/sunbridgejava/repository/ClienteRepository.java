package com.example.sunbridgejava.repository;

import com.example.sunbridgejava.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório para operações de acesso a dados da entidade {@link Cliente}.
 * 
 * Extende {@link JpaRepository} para fornecer métodos CRUD padrão e métodos de consulta personalizados.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    /**
     * Busca clientes cuja propriedade {@code nome} contém a string especificada.
     *
     * @param nome Parte ou totalidade do nome do cliente a ser buscado.
     * @return Lista de {@link Cliente} que correspondem ao critério de busca.
     */
    List<Cliente> findByNomeContainingIgnoreCase(String nome);

    /**
     * Busca clientes cuja propriedade {@code nome} contém a string especificada utilizando uma consulta JPQL personalizada.
     *
     * @param nome Parte ou totalidade do nome do cliente a ser buscado.
     * @return Lista de {@link Cliente} que correspondem ao critério de busca.
     */
    @Query("SELECT c FROM Cliente c WHERE c.nome LIKE %:nome%")
    List<Cliente> buscarClientesPorNome(String nome);

    /**
     * Busca clientes pelo e-mail.
     *
     * @param email Endereço de e-mail do cliente a ser buscado.
     * @return Lista de {@link Cliente} que correspondem ao e-mail fornecido.
     */
    List<Cliente> findByEmail(String email);

}
