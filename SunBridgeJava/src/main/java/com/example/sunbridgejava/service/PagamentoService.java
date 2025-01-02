package com.example.sunbridgejava.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sunbridgejava.model.Pagamento;
import com.example.sunbridgejava.repository.PagamentoRepository;

/**
 * Serviço responsável por gerenciar as operações relacionadas à entidade {@code Pagamento}.
 */
@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository r;
 
    /**
     * Busca um pagamento pelo ID.
     *
     * @param id Identificador do pagamento.
     * @return Optional contendo o pagamento, se encontrado.
     */
    public Optional<Pagamento> findById(int id) {
        System.out.println("Pesquisa Pagamento pelo id: " + id);
        return r.findById(id).map(pagamentos -> {
            return pagamentos;
        });
    }

    /**
     * Retorna todos os pagamentos registrados.
     *
     * @return Lista de todos os pagamentos.
     */
    public List<Pagamento> findAll() {
        System.out.println("Pesquisa Pagamento todos");
        return r.findAll();
    }

    /**
     * Deleta um pagamento pelo ID.
     *
     * @param id Identificador do pagamento.
     */
    public void deleteById(int id) {
        System.out.println("Delete Pagamento pelo id: " + id);
        r.deleteById(id);
    }

    /**
     * Atualiza as informações de um pagamento existente.
     *
     * @param id                 Identificador do pagamento.
     * @param PagamentoAtualizado Dados atualizados do pagamento.
     * @return Optional contendo o pagamento atualizado, se encontrado.
     */

    public Optional<Pagamento> update(int id, Pagamento PagamentoAtualizado) {
        System.out.println("Update Pagamento pelo id: " + id);
        return r.findById(id).map(PagamentoExistente -> {
            // Atualização dos campos necessários
            if (PagamentoAtualizado.getClienteID() != null) {
                PagamentoExistente.setClienteID(PagamentoAtualizado.getClienteID());
            }
            if (PagamentoAtualizado.getData_pagamento() != null) {
                PagamentoExistente.setData_pagamento(PagamentoAtualizado.getData_pagamento());
            }
            if (PagamentoAtualizado.getValor_pago() > 0) {
                PagamentoExistente.setValor_pago(PagamentoAtualizado.getValor_pago());
            }
            if (PagamentoAtualizado.getForma_pagamento() != null && !PagamentoAtualizado.getForma_pagamento().isEmpty()) {
                PagamentoExistente.setForma_pagamento(PagamentoAtualizado.getForma_pagamento());
            }
            if (PagamentoAtualizado.getStatus_pagamento() != null && !PagamentoAtualizado.getStatus_pagamento().isEmpty()) {
                PagamentoExistente.setStatus_pagamento(PagamentoAtualizado.getStatus_pagamento());
            }

            // Salva no banco de dados
            return r.save(PagamentoExistente);
        });
    }

    /**
     * Cria um novo pagamento.
     *
     * @param pagamentos Dados do pagamento a ser criado.
     * @return Pagamento criado.
     * @throws IllegalArgumentException Caso algum campo obrigatório esteja ausente ou inválido.
     */

    public Pagamento create(Pagamento pagamentos) {
        System.out.println("Create Pagamento");
        validaNulo(pagamentos);
        // Salvar Pagamento no banco
        return r.save(pagamentos);
    }

    /**
     * Valida os campos obrigatórios de um pagamento.
     *
     * @param pagamento Pagamento a ser validado.
     * @throws IllegalArgumentException Caso algum campo obrigatório esteja ausente ou inválido.
     */
    private void validaNulo(Pagamento pagamento) {
        if (pagamento.getClienteID() == null) {
            throw new IllegalArgumentException("O campo 'clienteID' não pode ser nulo.");
        }
        if (pagamento.getData_pagamento() == null) {
            throw new IllegalArgumentException("O campo 'data_pagamento' não pode ser nulo.");
        }
        if (pagamento.getValor_pago() <= 0) {
            throw new IllegalArgumentException("O campo 'valor_pago' deve ser maior que zero.");
        }
        if (pagamento.getForma_pagamento() == null || pagamento.getForma_pagamento().isEmpty()) {
            throw new IllegalArgumentException("O campo 'forma_pagamento' não pode ser nulo ou vazio.");
        }
        if (pagamento.getStatus_pagamento() == null || pagamento.getStatus_pagamento().isEmpty()) {
            throw new IllegalArgumentException("O campo 'status_pagamento' não pode ser nulo ou vazio.");
        }
    }
}
