package com.example.sunbridgejava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sunbridgejava.model.Fornecedor;
import com.example.sunbridgejava.repository.FornecedorRepository;

/**
 * Serviço responsável por gerenciar as operações relacionadas à entidade {@code Fornecedor}.
 */
@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository r;
 
    /**
     * Busca um fornecedor pelo ID.
     *
     * @param ID Identificador do fornecedor.
     * @return Optional contendo o fornecedor, se encontrado.
     */
    public Optional<Fornecedor> findById(int id) {
        System.out.println("Pesquisa Fornecedor pelo id: " + id);
        return r.findById(id).map(fornecedores -> {
            return fornecedores;
        });
    }

    /**
     * Retorna todos os fornecedores registrados.
     *
     * @return Lista de todos os fornecedores.
     */
    public List<Fornecedor> findAll() {
        System.out.println("Pesquisa Fornecedor todos");
        return r.findAll();
    }

    /**
     * Deleta um fornecedor pelo ID.
     *
     * @param id Identificador do fornecedor.
     */
    public void deleteById(int id) {
        System.out.println("Delete Fornecedor pelo id: " + id);
        r.deleteById(id);
    }

    /**
     * Atualiza as informações de um fornecedor existente.
     *
     * @param fornecedorID         Identificador do fornecedor.
     * @param fornecedorAtualizado Dados atualizados do fornecedor.
     * @return Optional contendo o fornecedor atualizado, se encontrado.
     */

    public Optional<Fornecedor> update(int fornecedorID, Fornecedor fornecedorAtualizado) {
        System.out.println("Update Fornecedor pelo id: " + fornecedorID);
        return r.findById(fornecedorID).map(fornecedorExistente -> {
            if (fornecedorAtualizado.getNome() != null) fornecedorExistente.setNome(fornecedorAtualizado.getNome());
            if (fornecedorAtualizado.getCedula() != null) fornecedorExistente.setCedula(fornecedorAtualizado.getCedula());
            if (fornecedorAtualizado.getTelefone() != null) fornecedorExistente.setTelefone(fornecedorAtualizado.getTelefone());
            if (fornecedorAtualizado.getRua() != null) fornecedorExistente.setRua(fornecedorAtualizado.getRua());
            if (fornecedorAtualizado.getBairro() != null) fornecedorExistente.setBairro(fornecedorAtualizado.getBairro());
            if (fornecedorAtualizado.getCidade() != null) fornecedorExistente.setCidade(fornecedorAtualizado.getCidade());
            if (fornecedorAtualizado.getProvincia() != null) fornecedorExistente.setProvincia(fornecedorAtualizado.getProvincia());
            if (fornecedorAtualizado.getCanton() != null) fornecedorExistente.setCanton(fornecedorAtualizado.getCanton());
            if (fornecedorAtualizado.getDistrito() != null) fornecedorExistente.setDistrito(fornecedorAtualizado.getDistrito());
            if (fornecedorAtualizado.getCodigo_postal() <= 0) fornecedorExistente.setCodigo_postal(fornecedorAtualizado.getCodigo_postal());
            if (fornecedorAtualizado.getComplemento() != null) fornecedorExistente.setComplemento(fornecedorAtualizado.getComplemento());

            // Salvar as alterações no banco de dados
            return r.save(fornecedorExistente);
        });
    } 

    /**
     * Cria um novo fornecedor.
     *
     * @param fornecedores Dados do fornecedor a ser criado.
     * @return Fornecedor criado.
     * @throws IllegalArgumentException Caso algum campo obrigatório esteja ausente ou inválido.
     */
    public Fornecedor create(Fornecedor fornecedores) {
        System.out.println("Create Fornecedor");
        validaNulo(fornecedores);
        // Salvar Fornecedor no banco
        return r.save(fornecedores);
    }

    /**
     * Valida os campos obrigatórios de um fornecedor.
     *
     * @param fornecedor Fornecedor a ser validado.
     * @throws IllegalArgumentException Caso algum campo obrigatório esteja ausente ou inválido.
     */
    private void validaNulo(Fornecedor fornecedor) {
        if (fornecedor.getNome() == null || fornecedor.getNome().isEmpty()) {
            throw new IllegalArgumentException("O campo 'nome' não pode ser nulo ou vazio.");
        }
        if (fornecedor.getCedula() == null || fornecedor.getCedula().isEmpty()) {
            throw new IllegalArgumentException("O campo 'cedula' não pode ser nulo ou vazio.");
        }
        if (fornecedor.getTelefone() == null || fornecedor.getTelefone().isEmpty()) {
            throw new IllegalArgumentException("O campo 'telefone' não pode ser nulo ou vazio.");
        }
        if (fornecedor.getRua() == null || fornecedor.getRua().isEmpty()) {
            throw new IllegalArgumentException("O campo 'rua' não pode ser nulo ou vazio.");
        }
        if (fornecedor.getBairro() == null || fornecedor.getBairro().isEmpty()) {
            throw new IllegalArgumentException("O campo 'bairro' não pode ser nulo ou vazio.");
        }
        if (fornecedor.getCidade() == null || fornecedor.getCidade().isEmpty()) {
            throw new IllegalArgumentException("O campo 'cidade' não pode ser nulo ou vazio.");
        }
        if (fornecedor.getProvincia() == null || fornecedor.getProvincia().isEmpty()) {
            throw new IllegalArgumentException("O campo 'provincia' não pode ser nulo ou vazio.");
        }
        if (fornecedor.getCanton() == null || fornecedor.getCanton().isEmpty()) {
            throw new IllegalArgumentException("O campo 'canton' não pode ser nulo ou vazio.");
        }
        if (fornecedor.getDistrito() == null || fornecedor.getDistrito().isEmpty()) {
            throw new IllegalArgumentException("O campo 'distrito' não pode ser nulo ou vazio.");
        }
        if (fornecedor.getCodigo_postal() <= 0) {
            throw new IllegalArgumentException("O campo 'codigo_postal' deve ser maior que zero.");
        }
    }
}
