package com.example.sunbridgejava.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sunbridgejava.model.Usuario;

/**
 * Repositório para operações de acesso a dados da entidade {@link Usuario}.
 * 
 * Extende {@link JpaRepository} para fornecer métodos CRUD padrão e métodos de consulta personalizados.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    /**
     * Busca usuários cuja propriedade {@code nome} contém a string especificada.
     * 
     * Similar à consulta SQL: {@code LIKE '%nome%'}.
     *
     * @param nome Parte ou totalidade do nome do usuário a ser buscado.
     * @return Lista de {@link Usuario} que correspondem ao critério de busca.
     */
    List<Usuario> findByNomeContainingIgnoreCase(String nome);
}
