package com.example.sunbridgejava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sunbridgejava.model.Item;
import com.example.sunbridgejava.repository.ItemRepository;

/**
 * Serviço responsável por gerenciar as operações relacionadas à entidade {@code Item}.
 */
@Service
public class ItemService {

    @Autowired
    private ItemRepository r;

    /**
     * Busca um item pelo ID.
     *
     * @param ID Identificador do item.
     * @return Optional contendo o item, se encontrado.
     */
    public Optional<Item> findById(int id) {
        System.out.println("Pesquisa Item pelo id: " + id);
        return r.findById(id).map(itens -> {
            return itens;
        });
    }

    /**
     * Retorna todos os itens registrados.
     *
     * @return Lista de todos os itens.
     */
    public List<Item> findAll() {
        System.out.println("Pesquisa Item Todos");
        return r.findAll();
    }

    /**
     * Deleta um item pelo ID.
     *
     * @param id Identificador do item.
     */
    public void deleteById(int id) {
        System.out.println("Delete Item pelo id: " + id);
        r.deleteById(id);
    }

    /**
     * Atualiza as informações de um item existente.
     *
     * @param id            Identificador do item.
     * @param ItemAtualizado Dados atualizados do item.
     * @return Optional contendo o item atualizado, se encontrado.
     */
    public Optional<Item> update(int id, Item ItemAtualizado) {
        System.out.println("Update Item pelo id: " + id);
        return r.findById(id).map(ItemExistente -> {
            // Atualização dos campos necessários
            if (ItemAtualizado.getNome() != null && !ItemAtualizado.getNome().isEmpty()) {
                ItemExistente.setNome(ItemAtualizado.getNome());
            }
            if (ItemAtualizado.getQuantidade() > 0) {
                ItemExistente.setQuantidade(ItemAtualizado.getQuantidade());
            }
            if (ItemAtualizado.getValor() > 0) {
                ItemExistente.setValor(ItemAtualizado.getValor());
            }
            if (ItemAtualizado.getCategoria() != null && !ItemAtualizado.getCategoria().isEmpty()) {
                ItemExistente.setCategoria(ItemAtualizado.getCategoria());
            }
            if (ItemAtualizado.getEstoqueID() != null) {
                ItemExistente.setEstoqueID(ItemAtualizado.getEstoqueID());
            }

            // Salva no banco de dados
            return r.save(ItemExistente);
        });
    }

    /**
     * Cria um novo item.
     *
     * @param itens Dados do item a ser criado.
     * @return Item criado.
     * @throws IllegalArgumentException Caso algum campo obrigatório esteja ausente ou inválido.
     */

    public Item create(Item itens) {
        System.out.println("Create Item");
        validaNulo(itens);
        // Salvar Item no banco
        return r.save(itens);
    }

    /**
     * Valida os campos obrigatórios de um item.
     *
     * @param item Item a ser validado.
     * @throws IllegalArgumentException Caso algum campo obrigatório esteja ausente ou inválido.
     */
    private void validaNulo(Item item) {
        if (item.getNome() == null || item.getNome().isEmpty()) {
            throw new IllegalArgumentException("O campo 'nome' não pode ser nulo ou vazio.");
        }
        if (item.getQuantidade() <= 0) {
            throw new IllegalArgumentException("O campo 'quantidade' deve ser maior que zero.");
        }
        if (item.getValor() <= 0) {
            throw new IllegalArgumentException("O campo 'valor' deve ser maior que zero.");
        }
        if (item.getCategoria() == null || item.getCategoria().isEmpty()) {
            throw new IllegalArgumentException("O campo 'categoria' não pode ser nulo ou vazio.");
        }
        if (item.getEstoqueID() == null) {
            throw new IllegalArgumentException("O campo 'estoqueID' não pode ser nulo.");
        }
    }

    /**
     * Verifica se há quantidade suficiente de um item em estoque.
     *
     * @param itemId       O identificador do item a ser verificado.
     * @param quantidadeRequerida   A quantidade desejada do item.
     * @throws IllegalArgumentException Se o item não tiver estoque suficiente ou não existir.
     */

    public void verificaEstoque(int itemId, int quantidadeRequerida) {
        // Obtém o item pelo ID
        Item item = r.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Item com ID " + itemId + " não encontrado."));

        // Verifica se a quantidade disponível é suficiente
        if (item.getQuantidade() < quantidadeRequerida) {
            throw new IllegalStateException("Não há este item disponível no estoque. Disponível: "
                    + item.getQuantidade() + ", Requerido: " + quantidadeRequerida);
        }
    }


}
