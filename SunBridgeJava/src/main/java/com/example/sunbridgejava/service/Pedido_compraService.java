package com.example.sunbridgejava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sunbridgejava.model.Pedido_compra;
import com.example.sunbridgejava.repository.Pedido_compraRepository;

/**
 * Serviço responsável por gerenciar as operações relacionadas à entidade {@code Pedido_compra}.
 */
@Service
public class Pedido_compraService {

    @Autowired
    private Pedido_compraRepository r;
 
    /**
     * Busca um pedido de compra pelo ID.
     *
     * @param id Identificador do pedido de compra.
     * @return Optional contendo o pedido de compra, se encontrado.
     */
    public Optional<Pedido_compra> findById(int id) {
        System.out.println("Pesquisa Pedido_compra pelo id: " + id);
        return r.findById(id).map(pedidos -> {
            return pedidos;
        });
    }

    /**
     * Retorna todos os pedidos de compra registrados.
     *
     * @return Lista de todos os pedidos de compra.
     */
    public List<Pedido_compra> findAll() {
        System.out.println("Pesquisa Pedido_compra todos");
        return r.findAll();
    }

    /**
     * Deleta um pedido de compra pelo ID.
     *
     * @param id Identificador do pedido de compra.
     */
    public void deleteById(int id) {
        System.out.println("Delete Pedido_compra pelo id: " + id);
        r.deleteById(id);
    }

    /**
     * Atualiza as informações de um pedido de compra existente.
     *
     * @param id                    Identificador do pedido de compra.
     * @param Pedido_compraAtualizado Dados atualizados do pedido de compra.
     * @return Optional contendo o pedido de compra atualizado, se encontrado.
     */
    public Optional<Pedido_compra> update(int id, Pedido_compra Pedido_compraAtualizado) {
        System.out.println("Update Pedido_compra pelo id: " + id);
        return r.findById(id).map(Pedido_compraExistente -> {
            // Atualização dos campos necessários
            if (Pedido_compraAtualizado.getData_compra() != null) {
                Pedido_compraExistente.setData_compra(Pedido_compraAtualizado.getData_compra());
            }
            if (Pedido_compraAtualizado.getValor() > 0) {
                Pedido_compraExistente.setValor(Pedido_compraAtualizado.getValor());
            }
            if (Pedido_compraAtualizado.getUsuarioID() != null) {
                Pedido_compraExistente.setUsuarioID(Pedido_compraAtualizado.getUsuarioID());
            }
            if (Pedido_compraAtualizado.getPagamento_fornecedorID() != null) {
                Pedido_compraExistente.setPagamento_fornecedorID(Pedido_compraAtualizado.getPagamento_fornecedorID());
            }
            if (Pedido_compraAtualizado.getFornecedorID() != null) {
                Pedido_compraExistente.setFornecedorID(Pedido_compraAtualizado.getFornecedorID());
            }

            // Salva no banco de dados
            return r.save(Pedido_compraExistente);
        });
    }

    /**
     * Cria um novo pedido de compra.
     *
     * @param pedidos Dados do pedido de compra a ser criado.
     * @return Pedido de compra criado.
     * @throws IllegalArgumentException Caso algum campo obrigatório esteja ausente ou inválido.
     */

    public Pedido_compra create(Pedido_compra pedidos) {
        System.out.println("Create Pedido_compra");
        validaNulo(pedidos);
        // Salvar Pedido_compra no banco
        return r.save(pedidos);
    }

    /**
     * Valida os campos obrigatórios de um pedido de compra.
     *
     * @param pedidoCompra Pedido de compra a ser validado.
     * @throws IllegalArgumentException Caso algum campo obrigatório esteja ausente ou inválido.
     */
    private void validaNulo(Pedido_compra pedidoCompra) {
        if (pedidoCompra.getData_compra() == null) {
            throw new IllegalArgumentException("O campo 'data_compra' não pode ser nulo.");
        }
        if (pedidoCompra.getValor() <= 0) {
            throw new IllegalArgumentException("O campo 'valor' deve ser maior que zero.");
        }
        if (pedidoCompra.getUsuarioID() == null) {
            throw new IllegalArgumentException("O campo 'usuarioID' não pode ser nulo.");
        }
        if (pedidoCompra.getPagamento_fornecedorID() == null) {
            throw new IllegalArgumentException("O campo 'pagamento_fornecedorID' não pode ser nulo.");
        }
        if (pedidoCompra.getFornecedorID() == null) {
            throw new IllegalArgumentException("O campo 'fornecedorID' não pode ser nulo.");
        }
    }
}
