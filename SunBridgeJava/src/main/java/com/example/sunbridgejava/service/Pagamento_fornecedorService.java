package com.example.sunbridgejava.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sunbridgejava.model.Pagamento_fornecedor;
import com.example.sunbridgejava.repository.Pagamento_fornecedorRepository;

/**
 * Serviço responsável por gerenciar as operações relacionadas à entidade {@code Pagamento_fornecedor}.
 */
@Service
public class Pagamento_fornecedorService {

    @Autowired
    private Pagamento_fornecedorRepository r;

    /**
     * Busca um pagamento de fornecedor pelo ID.
     *
     * @param id Identificador do pagamento de fornecedor.
     * @return Optional contendo o pagamento de fornecedor, se encontrado.
     */
    public Optional<Pagamento_fornecedor> findById(int id) {
        System.out.println("Pesquisa Pagamento_fornecedor pelo id: " + id);
        return r.findById(id).map(pagamentos -> {
            return pagamentos;
        });
    }

    /**
     * Retorna todos os pagamentos de fornecedores registrados.
     *
     * @return Lista de todos os pagamentos de fornecedores.
     */
    public List<Pagamento_fornecedor> findAll() {
        System.out.println("Pesquisa Pagamento_fornecedor todos");
        return r.findAll();
    }

    /**
     * Deleta um pagamento de fornecedor pelo ID.
     *
     * @param id Identificador do pagamento de fornecedor.
     */
    public void deleteById(int id) {
        System.out.println("Delete Pagamento_fornecedor pelo id: " + id);
        r.deleteById(id);
    }

    /**
     * Atualiza as informações de um pagamento de fornecedor existente.
     *
     * @param id                          Identificador do pagamento de fornecedor.
     * @param Pagamento_fornecedorAtualizado Dados atualizados do pagamento de fornecedor.
     * @return Optional contendo o pagamento de fornecedor atualizado, se encontrado.
     */
    public Optional<Pagamento_fornecedor> update(int id, Pagamento_fornecedor Pagamento_fornecedorAtualizado) {
        System.out.println("Update Pagamento_fornecedor pelo id: " + id);
        return r.findById(id).map(Pagamento_fornecedorExistente -> {
            // Atualização dos campos necessários
            if (Pagamento_fornecedorAtualizado.getData_pagamento() != null) {
                Pagamento_fornecedorExistente.setData_pagamento(Pagamento_fornecedorAtualizado.getData_pagamento());
            }
            if (Pagamento_fornecedorAtualizado.getValor() != null && Pagamento_fornecedorAtualizado.getValor() > 0) {
                Pagamento_fornecedorExistente.setValor(Pagamento_fornecedorAtualizado.getValor());
            }
            if (Pagamento_fornecedorAtualizado.getForma_pagamento() != null && !Pagamento_fornecedorAtualizado.getForma_pagamento().isEmpty()) {
                Pagamento_fornecedorExistente.setForma_pagamento(Pagamento_fornecedorAtualizado.getForma_pagamento());
            }

            // Salva no banco de dados
            return r.save(Pagamento_fornecedorExistente);
        });
    }

    /**
     * Cria um novo pagamento de fornecedor.
     *
     * @param pagamentos Dados do pagamento de fornecedor a ser criado.
     * @return Pagamento de fornecedor criado.
     * @throws IllegalArgumentException Caso algum campo obrigatório esteja ausente ou inválido.
     */

    public Pagamento_fornecedor create(Pagamento_fornecedor pagamentos) {
        System.out.println("Create Pagamento_fornecedor");
        validaNulo(pagamentos);
        // Salvar Pagamento_fornecedor no banco
        return r.save(pagamentos);
    }

    /**
     * Valida os campos obrigatórios de um pagamento de fornecedor.
     *
     * @param pagamentoFornecedor Pagamento de fornecedor a ser validado.
     * @throws IllegalArgumentException Caso algum campo obrigatório esteja ausente ou inválido.
     */
    private void validaNulo(Pagamento_fornecedor pagamentoFornecedor) {
        if (pagamentoFornecedor.getData_pagamento() == null) {
            throw new IllegalArgumentException("O campo 'data_pagamento' não pode ser nulo.");
        }
        if (pagamentoFornecedor.getValor() == null || pagamentoFornecedor.getValor() <= 0) {
            throw new IllegalArgumentException("O campo 'valor' deve ser maior que zero e não pode ser nulo.");
        }
        if (pagamentoFornecedor.getForma_pagamento() == null || pagamentoFornecedor.getForma_pagamento().isEmpty()) {
            throw new IllegalArgumentException("O campo 'forma_pagamento' não pode ser nulo ou vazio.");
        }
    }
}
