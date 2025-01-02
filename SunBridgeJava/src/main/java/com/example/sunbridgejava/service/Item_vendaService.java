package com.example.sunbridgejava.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sunbridgejava.model.Item_venda;
import com.example.sunbridgejava.repository.Item_vendaRepository;

/**
 * Serviço responsável por gerenciar as operações relacionadas à entidade {@code Item_venda}.
 */
@Service
public class Item_vendaService {

    @Autowired
    private Item_vendaRepository r;

    @Autowired
    private ItemService is; 

    /**
     * Busca um item de venda pelo ID.
     *
     * @param ID Identificador do item de venda.
     * @return Optional contendo o item de venda, se encontrado.
     */
    public Optional<Item_venda> findById(int id) {
        System.out.println("Pesquisa Item_venda pelo id: " + id);
        return r.findById(id).map(itens -> {
            return itens;
        });
    }

    /**
     * Retorna todos os itens de venda registrados.
     *
     * @return Lista de todos os itens de venda.
     */
    public List<Item_venda> findAll() {
        System.out.println("Pesquisa Item_venda todos");
        return r.findAll();
    }

    /**
     * Deleta um item de venda pelo ID.
     *
     * @param id Identificador do item de venda.
     */
    public void deleteById(int id) {
        System.out.println("Delete Item_venda pelo id: " + id);
        r.deleteById(id);
    }

    /**
     * Atualiza as informações de um item de venda existente.
     *
     * @param id                Identificador do item de venda.
     * @param Item_vendaAtualizado Dados atualizados do item de venda.
     * @return Optional contendo o item de venda atualizado, se encontrado.
     */
    public Optional<Item_venda> update(int id, Item_venda Item_vendaAtualizado) {
        System.out.println("Update Item_venda pelo id: " + id);
        return r.findById(id).map(Item_vendaExistente -> {
            // Atualização dos campos necessários
            if (Item_vendaAtualizado.getQuantidade() > 0) Item_vendaExistente.setQuantidade(Item_vendaAtualizado.getQuantidade());
            if (Item_vendaAtualizado.getValor_prod() > 0) Item_vendaExistente.setValor_prod(Item_vendaAtualizado.getValor_prod());
            if (Item_vendaAtualizado.getPed_venda() != null) Item_vendaExistente.setPed_venda(Item_vendaAtualizado.getPed_venda());
            if (Item_vendaAtualizado.getIt_cod() != null) Item_vendaExistente.setIt_cod(Item_vendaAtualizado.getIt_cod());

            // Salvar as alterações no banco de dados
            return r.save(Item_vendaExistente);
        });
    }

    /**
     * Cria um novo item de venda.
     *
     * @param itens Dados do item de venda a ser criado.
     * @return Item de venda criado.
     * @throws IllegalArgumentException Caso algum campo obrigatório esteja ausente ou inválido.
     */

    public Item_venda create(Item_venda itens) {
        System.out.println("Create Item_venda");
        validaNulo(itens);
        is.verificaEstoque(itens.getIt_cod().getIt_cod(), itens.getQuantidade());
        // Salvar Item_venda no banco
        return r.save(itens);
    }

    /**
     * Valida os campos obrigatórios de um item de venda.
     *
     * @param itemVenda Item de venda a ser validado.
     * @throws IllegalArgumentException Caso algum campo obrigatório esteja ausente ou inválido.
     */
    private void validaNulo(Item_venda itemVenda) {
        if (itemVenda.getPed_venda() == null) {
            throw new IllegalArgumentException("O campo 'ped_venda' não pode ser nulo.");
        }
        if (itemVenda.getQuantidade() <= 0) {
            throw new IllegalArgumentException("O campo 'quantidade' deve ser maior que zero.");
        }
        if (itemVenda.getValor_prod() <= 0) {
            throw new IllegalArgumentException("O campo 'valor_prod' deve ser maior que zero.");
        }
        if (itemVenda.getIt_cod() == null) {
            throw new IllegalArgumentException("O campo 'it_cod' não pode ser nulo.");
        }
    }
}
