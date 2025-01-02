package com.example.sunbridgejava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sunbridgejava.model.Pedido_fornecedor;
import com.example.sunbridgejava.repository.Pedido_fornecedorRepository;

/**
 * Serviço responsável por gerenciar as operações relacionadas à entidade {@code Pedido_fornecedor}.
 */
@Service
public class Pedido_fornecedorService {

    @Autowired
    private Pedido_fornecedorRepository r;
 
    /**
     * Busca um pedido de fornecedor pelo ID.
     *
     * @param id Identificador do pedido de fornecedor.
     * @return Optional contendo o pedido de fornecedor, se encontrado.
     */
    public Optional<Pedido_fornecedor> findById(int id) {
        System.out.println("Pesquisa Pedido_fornecedor pelo id: " + id);
        return r.findById(id).map(pedidos -> {
            return pedidos;
        });
    }

    /**
     * Retorna todos os pedidos de fornecedores registrados.
     *
     * @return Lista de todos os pedidos de fornecedores.
     */
    public List<Pedido_fornecedor> findAll() {
        System.out.println("Pesquisa Pedido_fornecedor Todos");
        return r.findAll();
    }

    /**
     * Deleta um pedido de fornecedor pelo ID.
     *
     * @param id Identificador do pedido de fornecedor.
     */
    public void deleteById(int id) {
        System.out.println("Delete Pedido_fornecedor pelo id: " + id);
        r.deleteById(id);
    }

    /**
     * Atualiza as informações de um pedido de fornecedor existente.
     *
     * @param id                           Identificador do pedido de fornecedor.
     * @param Pedido_fornecedorAtualizado Dados atualizados do pedido de fornecedor.
     * @return Optional contendo o pedido de fornecedor atualizado, se encontrado.
     */
    public Optional<Pedido_fornecedor> update(int id, Pedido_fornecedor Pedido_fornecedorAtualizado) {
        System.out.println("Update Pedido_fornecedor pelo id: " + id);
        return r.findById(id).map(Pedido_fornecedorExistente -> {
            // Atualização dos campos necessários
            if (Pedido_fornecedorAtualizado.getQuantidade() > 0) {
                Pedido_fornecedorExistente.setQuantidade(Pedido_fornecedorAtualizado.getQuantidade());
            }
            if (Pedido_fornecedorAtualizado.getValor() > 0) {
                Pedido_fornecedorExistente.setValor(Pedido_fornecedorAtualizado.getValor());
            }
            if (Pedido_fornecedorAtualizado.getPedido_compra() != null) {
                Pedido_fornecedorExistente.setPedido_compra(Pedido_fornecedorAtualizado.getPedido_compra());
            }
            if (Pedido_fornecedorAtualizado.getIt_cod() != null) {
                Pedido_fornecedorExistente.setIt_cod(Pedido_fornecedorAtualizado.getIt_cod());
            }
            if (Pedido_fornecedorAtualizado.getEstoqueID() != null) {
                Pedido_fornecedorExistente.setEstoqueID(Pedido_fornecedorAtualizado.getEstoqueID());
            }

            // Salva no banco de dados
            return r.save(Pedido_fornecedorExistente);
        });
    }

    /**
     * Cria um novo pedido de fornecedor.
     *
     * @param pedidos Dados do pedido de fornecedor a ser criado.
     * @return Pedido de fornecedor criado.
     * @throws IllegalArgumentException Caso algum campo obrigatório esteja ausente ou inválido.
     */

    public Pedido_fornecedor create(Pedido_fornecedor pedidos) {
        System.out.println("Create Pedido_fornecedor");
        validaNulo(pedidos);
        // Salvar Pedido_fornecedor no banco
        return r.save(pedidos);
    }

    /**
     * Valida os campos obrigatórios de um pedido de fornecedor.
     *
     * @param pedidoFornecedor Pedido de fornecedor a ser validado.
     * @throws IllegalArgumentException Caso algum campo obrigatório esteja ausente ou inválido.
     */
    private void validaNulo(Pedido_fornecedor pedidoFornecedor) {
        if (pedidoFornecedor.getQuantidade() <= 0) {
            throw new IllegalArgumentException("O campo 'quantidade' deve ser maior que zero.");
        }
        if (pedidoFornecedor.getValor() <= 0) {
            throw new IllegalArgumentException("O campo 'valor' deve ser maior que zero.");
        }
        if (pedidoFornecedor.getPedido_compra() == null) {
            throw new IllegalArgumentException("O campo 'pedido_compra' não pode ser nulo.");
        }
        if (pedidoFornecedor.getIt_cod() == null) {
            throw new IllegalArgumentException("O campo 'it_cod' não pode ser nulo.");
        }
        if (pedidoFornecedor.getEstoqueID() == null) {
            throw new IllegalArgumentException("O campo 'estoqueID' não pode ser nulo.");
        }
    }
}
