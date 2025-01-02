package com.example.sunbridgejava.repository;

import com.example.sunbridgejava.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório para operações de acesso a dados da entidade {@link Empresa}.
 * 
 * Extende {@link JpaRepository} para fornecer métodos CRUD padrão e métodos de consulta personalizados.
 */
@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

    /**
     * Busca empresas cuja propriedade {@code nome} contém a string especificada.
     *
     * @param nome Parte ou totalidade do nome da empresa a ser buscada.
     * @return Lista de {@link Empresa} que correspondem ao critério de busca.
     */
    List<Empresa> findByNomeContaining(String nome);

    /**
     * Busca empresas cuja propriedade {@code nome} contém a string especificada utilizando uma consulta JPQL personalizada.
     *
     * @param nome Parte ou totalidade do nome da empresa a ser buscada.
     * @return Lista de {@link Empresa} que correspondem ao critério de busca.
     */
    @Query("SELECT e FROM Empresa e WHERE e.nome LIKE %:nome%")
    List<Empresa> buscarEmpresasPorNome(String nome);

    /**
     * Busca empresas pelo endereço de e-mail.
     *
     * @param email Endereço de e-mail da empresa a ser buscada.
     * @return Lista de {@link Empresa} que correspondem ao e-mail fornecido.
     */
    List<Empresa> findByEmail(String email);
}
