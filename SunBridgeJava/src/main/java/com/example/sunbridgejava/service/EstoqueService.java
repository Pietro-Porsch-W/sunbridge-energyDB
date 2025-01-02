package com.example.sunbridgejava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sunbridgejava.model.Estoque;
import com.example.sunbridgejava.repository.EstoqueRepository;

/**
 * Serviço responsável por gerenciar as operações relacionadas à entidade {@code Estoque}.
 */
@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository r; 

    /**
     * Busca um item de estoque pelo ID.
     *
     * @param ID Identificador do item de estoque.
     * @return Optional contendo o item de estoque, se encontrado.
     */
    public Optional<Estoque> findById(int id) {
        System.out.println("Pesquisa Estoque pelo id: " + id);
        return r.findById(id).map(estoques -> {
            return estoques;
        });
    }

    /**
     * Retorna todos os itens de estoque registrados.
     *
     * @return Lista de todos os itens de estoque.
     */
    public List<Estoque> findAll() {
        System.out.println("Pesquisa Estoque todos");
        return r.findAll();
    }

    /**
     * Deleta um item de estoque pelo ID.
     *
     * @param id Identificador do item de estoque.
     */
    public void deleteById(int id) {
        System.out.println("Delete Estoque pelo id: " + id);
        r.deleteById(id);
    }

    /**
     * Atualiza as informações de um item de estoque existente.
     *
     * @param estoqueID          Identificador do item de estoque.
     * @param estoqueAtualizado Dados atualizados do item de estoque.
     * @return Optional contendo o item de estoque atualizado, se encontrado.
     */
    public Optional<Estoque> update(int estoqueID, Estoque estoqueAtualizado) {
        System.out.println("Update Estoque pelo id: " + estoqueID);
        return r.findById(estoqueID).map(estoqueExistente -> {
            if (estoqueAtualizado.getRua() != null) estoqueExistente.setRua(estoqueAtualizado.getRua());
            if (estoqueAtualizado.getPrateleira() != null) estoqueExistente.setPrateleira(estoqueAtualizado.getPrateleira());
            if (estoqueAtualizado.getPeso() > 0) estoqueExistente.setPeso(estoqueAtualizado.getPeso());
            if (estoqueAtualizado.getData_entrada() != null) estoqueExistente.setData_entrada(estoqueAtualizado.getData_entrada());
            if (estoqueAtualizado.getData_saida() != null) estoqueExistente.setData_saida(estoqueAtualizado.getData_saida());
            if (estoqueAtualizado.getValor_compra() > 0) estoqueExistente.setValor_compra(estoqueAtualizado.getValor_compra());
            if (estoqueAtualizado.getValor_venda() > 0) estoqueExistente.setValor_venda(estoqueAtualizado.getValor_venda());

            // Salvar as alterações no banco de dados
            return r.save(estoqueExistente);
        });
    }

    /**
     * Cria um novo item de estoque.
     *
     * @param estoques Dados do item de estoque a ser criado.
     * @return Item de estoque criado.
     * @throws IllegalArgumentException Caso algum campo obrigatório esteja ausente ou inválido.
     */
    public Estoque create(Estoque estoques) {
        System.out.println("Create Estoque");
        validaNulo(estoques);
        // Salvar Estoque no banco
        return r.save(estoques);
    }

    /**
     * Valida os campos obrigatórios de um item de estoque.
     *
     * @param estoque Item de estoque a ser validado.
     * @throws IllegalArgumentException Caso algum campo obrigatório esteja ausente ou inválido.
     */
    private void validaNulo(Estoque estoque) {
        if (estoque.getRua() == null || estoque.getRua().isEmpty()) {
            throw new IllegalArgumentException("O campo 'rua' não pode ser nulo ou vazio.");
        }
        if (estoque.getPrateleira() == null || estoque.getPrateleira().isEmpty()) {
            throw new IllegalArgumentException("O campo 'prateleira' não pode ser nulo ou vazio.");
        }
        if (estoque.getPeso() <= 0) {
            throw new IllegalArgumentException("O campo 'peso' deve ser maior que zero.");
        }
        if (estoque.getValor_venda() <= 0) {
            throw new IllegalArgumentException("O campo 'valor_venda' deve ser maior que zero.");
        }
    }
}
