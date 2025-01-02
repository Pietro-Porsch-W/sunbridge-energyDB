package com.example.sunbridgejava.repository;

import com.example.sunbridgejava.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório para operações de acesso a dados da entidade {@link Fornecedor}.
 * 
 * Extende {@link JpaRepository} para fornecer métodos CRUD padrão e métodos de consulta personalizados.
 */
@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

    /**
     * Busca fornecedores cuja propriedade {@code nome} contém a string especificada.
     *
     * @param nome Parte ou totalidade do nome do fornecedor a ser buscado.
     * @return Lista de {@link Fornecedor} que correspondem ao critério de busca.
     */
    List<Fornecedor> findByNomeContaining(String nome);

    /**
     * Busca fornecedores cuja propriedade {@code nome} contém a string especificada utilizando uma consulta JPQL personalizada.
     *
     * @param nome Parte ou totalidade do nome do fornecedor a ser buscado.
     * @return Lista de {@link Fornecedor} que correspondem ao critério de busca.
     */
    @Query("SELECT f FROM Fornecedor f WHERE f.nome LIKE %:nome%")
    List<Fornecedor> buscarPorNome(String nome);
}
