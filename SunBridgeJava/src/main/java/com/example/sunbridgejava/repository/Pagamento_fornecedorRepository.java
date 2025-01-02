package com.example.sunbridgejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sunbridgejava.model.Pagamento_fornecedor;

/**
 * Repositório para operações de acesso a dados da entidade {@link Pagamento_fornecedor}.
 * 
 * Extende {@link JpaRepository} para fornecer métodos CRUD padrão e métodos de consulta personalizados.
 * 
 * Aqui você pode adicionar métodos personalizados, se necessário.
 */
@Repository
public interface Pagamento_fornecedorRepository extends JpaRepository<Pagamento_fornecedor, Integer> {
}


