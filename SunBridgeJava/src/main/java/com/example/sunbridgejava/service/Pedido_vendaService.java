package com.example.sunbridgejava.service;

import java.util.List;
import java.util.Optional;
import com.example.sunbridgejava.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sunbridgejava.model.Pedido_venda;
import com.example.sunbridgejava.repository.Pedido_vendaRepository;

/**
 * Serviço responsável por gerenciar as operações relacionadas à entidade {@code Pedido_venda}.
 */
@Service
public class Pedido_vendaService {

    @Autowired
    private Pedido_vendaRepository r;

    /**
     * Busca um pedido de venda pelo ID.
     *
     * @param id Identificador do pedido de venda.
     * @return Optional contendo o pedido de venda, se encontrado.
     */
    public Optional<Pedido_venda> findById(int id) {
        System.out.println("Pesquisa Pedido_venda pelo id: " + id);
        return r.findById(id).map(pedido_vendas -> {
            return pedido_vendas;
        });
    }

    /**
     * Retorna todos os pedidos de venda registrados.
     *
     * @return Lista de todos os pedidos de venda.
     */
    public List<Pedido_venda> findAll() {
        System.out.println("Pesquisa Pedido_venda todos");
        return r.findAll();
    }

    /**
     * Busca pedidos de venda associados a um cliente.
     *
     * @param id Cliente associado ao pedido de venda.
     * @return Lista de pedidos de venda encontrados.
     */
    public List<Pedido_venda> findByclienteID(Cliente id) {
        System.out.println("Pesquisa Pedido_venda pelo clienteID: " + id);
        return r.findByclienteID(id);
    }

    /**
     * Deleta um pedido de venda pelo ID.
     *
     * @param id Identificador do pedido de venda.
     */
    public void deleteById(int id) {
        System.out.println("Delete Pedido_venda pelo id: " + id);
        r.deleteById(id);
    }

    /**
     * Atualiza as informações de um pedido de venda existente.
     *
     * @param id                     Identificador do pedido de venda.
     * @param Pedido_vendaAtualizado Dados atualizados do pedido de venda.
     * @return Optional contendo o pedido de venda atualizado, se encontrado.
     */
    public Optional<Pedido_venda> update(int id, Pedido_venda Pedido_vendaAtualizado) {
        System.out.println("Update Pedido_venda pelo id: " + id);
        return r.findById(id).map(Pedido_vendaExistente -> {
            // Atualização dos campos necessários
            if (Pedido_vendaAtualizado.getClienteID() != null) {
                Pedido_vendaExistente.setClienteID(Pedido_vendaAtualizado.getClienteID());
            }
            if (Pedido_vendaAtualizado.getData_venda() != null) {
                Pedido_vendaExistente.setData_venda(Pedido_vendaAtualizado.getData_venda());
            }
            if (Pedido_vendaAtualizado.getData_instalacao() != null) {
                Pedido_vendaExistente.setData_instalacao(Pedido_vendaAtualizado.getData_instalacao());
            }
            if (Pedido_vendaAtualizado.getValor() > 0) {
                Pedido_vendaExistente.setValor(Pedido_vendaAtualizado.getValor());
            }
            if (Pedido_vendaAtualizado.getDesconto() >= 0) {
                Pedido_vendaExistente.setDesconto(Pedido_vendaAtualizado.getDesconto());
            }

            // Salva no banco de dados
            return r.save(Pedido_vendaExistente);
        });
    }

    /**
     * Cria um novo pedido de venda.
     *
     * @param pedido_vendas Dados do pedido de venda a ser criado.
     * @return Pedido de venda criado.
     * @throws IllegalArgumentException Caso algum campo obrigatório esteja ausente ou inválido.
     */
    
    public Pedido_venda create(Pedido_venda pedido_vendas) {
        System.out.println("Create Pedido_venda");
        validaNulo(pedido_vendas);
        // Salvar Pedido_venda no banco
        return r.save(pedido_vendas);
    }

    /**
     * Valida os campos obrigatórios de um pedido de venda.
     *
     * @param pedidoVenda Pedido de venda a ser validado.
     * @throws IllegalArgumentException Caso algum campo obrigatório esteja ausente ou inválido.
     */
    private void validaNulo(Pedido_venda pedidoVenda) {
        if (pedidoVenda.getClienteID() == null) {
            throw new IllegalArgumentException("O campo 'clienteID' não pode ser nulo.");
        }
        if (pedidoVenda.getData_venda() == null) {
            throw new IllegalArgumentException("O campo 'data_venda' não pode ser nulo.");
        }
        if (pedidoVenda.getValor() <= 0) {
            throw new IllegalArgumentException("O campo 'valor' deve ser maior que zero.");
        }
        if (pedidoVenda.getDesconto() < 0) {
            throw new IllegalArgumentException("O campo 'desconto' não pode ser negativo.");
        }
    }
}
