package com.example.sunbridgejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sunbridgejava.model.Pagamento;

/**
 * Repositório para operações de acesso a dados da entidade {@link Pagamento}.
 * 
 * Extende {@link JpaRepository} para fornecer métodos CRUD padrão e métodos de consulta personalizados.
 */
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

    /**
     * Método personalizado para buscar pagamentos cujo {@code clienteID} contém a string especificada.
     * 
     * Similar à consulta SQL: {@code LIKE '%clienteID%'}.
     *
     * @param clienteID Parte ou totalidade do ID do cliente a ser buscado.
     * @return Lista de {@link Pagamento} que correspondem ao critério de busca.
     */
    // List<Pagamento> findByClienteIDContaining(String clienteID);
}
