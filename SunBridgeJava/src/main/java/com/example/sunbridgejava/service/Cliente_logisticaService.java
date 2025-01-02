package com.example.sunbridgejava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sunbridgejava.model.Cliente_logistica;
import com.example.sunbridgejava.repository.Cliente_logisticaRepository;

/**
 * Serviço responsável por gerenciar operações relacionadas à entidade {@link Cliente_logistica}.
 * Este serviço fornece métodos para criação, leitura, atualização e exclusão de registros de cliente logístico.
 */
@Service
public class Cliente_logisticaService {

    @Autowired
    private Cliente_logisticaRepository r;

    /**
     * Deleta um registro de {@link Cliente_logistica} pelo ID.
     *
     * @param ID Identificador do registro a ser deletado.
     */
    public void delete(int ID) {
        System.out.println("Delete de Cliente Logistica pelo ID: " + ID);
        r.deleteById(ID);
    }

    /**
     * Busca um registro de {@link Cliente_logistica} pelo ID.
     *
     * @param ID Identificador do registro a ser buscado.
     * @return {@link Optional} contendo o registro, se encontrado.
     */
    public Optional<Cliente_logistica> findById(int ID) {
        System.out.println("Pesquisa de Cliente Logistica pelo ID: " + ID);
        return r.findById(ID).map(clientes -> {
            return clientes;
        });
    }

    /**
     * Busca registros de {@link Cliente_logistica} cujo nome contém uma string especificada (ignora maiúsculas e minúsculas).
     *
     * @param nome Parte ou totalidade do nome a ser buscado.
     * @return Lista de registros que correspondem ao critério de busca.
     */
    public List<Cliente_logistica> findByName(String nome) {
        System.out.println("Pesquisa de Cliente Logistica pelo Nome contendo: " + nome);
        return r.findByNomeContainingIgnoreCase(nome);
    }

    /**
     * Retorna todos os registros de {@link Cliente_logistica}.
     *
     * @return Lista de todos os registros no banco de dados.
     */
    public List<Cliente_logistica> findAll() {
        System.out.println("Pesquisa de Cliente Logistica por todos");
        return r.findAll();
    }

    /**
     * Atualiza um registro de {@link Cliente_logistica} pelo ID.
     *
     * @param logisticaID              Identificador do registro a ser atualizado.
     * @param clienteLogisticaAtualizado Dados atualizados do registro.
     * @return {@link Optional} contendo o registro atualizado, se encontrado.
     */
    public Optional<Cliente_logistica> update(int logisticaID, Cliente_logistica clienteLogisticaAtualizado) {
        System.out.println("Update de Cliente Logistica pelo ID: " + logisticaID);
        return r.findById(logisticaID).map(clienteLogisticaExistente -> {
            if (clienteLogisticaAtualizado.getCedula() != null)
                clienteLogisticaExistente.setCedula(clienteLogisticaAtualizado.getCedula());
            if (clienteLogisticaAtualizado.getData_entrega() != null)
                clienteLogisticaExistente.setData_entrega(clienteLogisticaAtualizado.getData_entrega());
            if (clienteLogisticaAtualizado.getNome() != null)
                clienteLogisticaExistente.setNome(clienteLogisticaAtualizado.getNome());
            if (clienteLogisticaAtualizado.getData_nascimento() != null)
                clienteLogisticaExistente.setData_nascimento(clienteLogisticaAtualizado.getData_nascimento());
            if (clienteLogisticaAtualizado.getGenero() != '\0')
                clienteLogisticaExistente.setGenero(clienteLogisticaAtualizado.getGenero());
            if (clienteLogisticaAtualizado.getEmail() != null)
                clienteLogisticaExistente.setEmail(clienteLogisticaAtualizado.getEmail());
            if (clienteLogisticaAtualizado.getTelefone() != null)
                clienteLogisticaExistente.setTelefone(clienteLogisticaAtualizado.getTelefone());
            if (clienteLogisticaAtualizado.getRua() != null)
                clienteLogisticaExistente.setRua(clienteLogisticaAtualizado.getRua());
            if (clienteLogisticaAtualizado.getBairro() != null)
                clienteLogisticaExistente.setBairro(clienteLogisticaAtualizado.getBairro());
            if (clienteLogisticaAtualizado.getCidade() != null)
                clienteLogisticaExistente.setCidade(clienteLogisticaAtualizado.getCidade());
            if (clienteLogisticaAtualizado.getProvincia() != null)
                clienteLogisticaExistente.setProvincia(clienteLogisticaAtualizado.getProvincia());
            if (clienteLogisticaAtualizado.getCanton() != null)
                clienteLogisticaExistente.setCanton(clienteLogisticaAtualizado.getCanton());
            if (clienteLogisticaAtualizado.getDistrito() != null)
                clienteLogisticaExistente.setDistrito(clienteLogisticaAtualizado.getDistrito());
            if (clienteLogisticaAtualizado.getCodigo_postal() > 0)
                clienteLogisticaExistente.setCodigo_postal(clienteLogisticaAtualizado.getCodigo_postal());
            if (clienteLogisticaAtualizado.getComplemento() != null)
                clienteLogisticaExistente.setComplemento(clienteLogisticaAtualizado.getComplemento());
            if (clienteLogisticaAtualizado.getPed_venda() != null)
                clienteLogisticaExistente.setPed_venda(clienteLogisticaAtualizado.getPed_venda());

            return r.save(clienteLogisticaExistente);
        });
    }

    /**
     * Cria um novo registro de {@link Cliente_logistica}.
     *
     * @param clientes Dados do novo registro a ser criado.
     * @return Registro criado.
     * @throws IllegalArgumentException Se os dados forem inválidos ou estiverem ausentes.
     */
    public Cliente_logistica create(Cliente_logistica clientes) {
        System.out.println("Create de Cliente Logistica do ID: " + clientes.getLogisticaID());
        validaNulo(clientes);
        return r.save(clientes);
    }

    /**
     * Valida os dados obrigatórios do {@link Cliente_logistica}.
     *
     * @param clienteLogistica Dados a serem validados.
     * @throws IllegalArgumentException Se algum campo obrigatório estiver ausente ou inválido.
     */
    private void validaNulo(Cliente_logistica clienteLogistica) {
        if (clienteLogistica.getPed_venda() == null) {
            throw new IllegalArgumentException("O campo 'ped_venda' não pode ser nulo.");
        }
        if (clienteLogistica.getData_entrega() == null) {
            throw new IllegalArgumentException("O campo 'data_entrega' não pode ser nulo.");
        }
        if (clienteLogistica.getNome() == null || clienteLogistica.getNome().isEmpty()) {
            throw new IllegalArgumentException("O campo 'nome' não pode ser nulo ou vazio.");
        }
        char genero = Character.toUpperCase(clienteLogistica.getGenero());
        if (genero != 'F' && genero != 'M') {
            throw new IllegalArgumentException("O campo 'genero' deve ser 'F' ou 'M'.");
        }
        if (clienteLogistica.getEmail() == null || clienteLogistica.getEmail().isEmpty()) {
            throw new IllegalArgumentException("O campo 'email' não pode ser nulo ou vazio.");
        }
        if (clienteLogistica.getTelefone() == null || clienteLogistica.getTelefone().isEmpty()) {
            throw new IllegalArgumentException("O campo 'telefone' não pode ser nulo ou vazio.");
        }
        if (clienteLogistica.getRua() == null || clienteLogistica.getRua().isEmpty()) {
            throw new IllegalArgumentException("O campo 'rua' não pode ser nulo ou vazio.");
        }
        if (clienteLogistica.getBairro() == null || clienteLogistica.getBairro().isEmpty()) {
            throw new IllegalArgumentException("O campo 'bairro' não pode ser nulo ou vazio.");
        }
        if (clienteLogistica.getCidade() == null || clienteLogistica.getCidade().isEmpty()) {
            throw new IllegalArgumentException("O campo 'cidade' não pode ser nulo ou vazio.");
        }
        if (clienteLogistica.getProvincia() == null || clienteLogistica.getProvincia().isEmpty()) {
            throw new IllegalArgumentException("O campo 'provincia' não pode ser nulo ou vazio.");
        }
        if (clienteLogistica.getCanton() == null || clienteLogistica.getCanton().isEmpty()) {
            throw new IllegalArgumentException("O campo 'canton' não pode ser nulo ou vazio.");
        }
        if (clienteLogistica.getDistrito() == null || clienteLogistica.getDistrito().isEmpty()) {
            throw new IllegalArgumentException("O campo 'distrito' não pode ser nulo ou vazio.");
        }
        if (clienteLogistica.getCodigo_postal() <= 0) {
            throw new IllegalArgumentException("O campo 'codigo_postal' não pode ser nulo ou vazio.");
        }
        if (clienteLogistica.getComplemento() == null || clienteLogistica.getComplemento().isEmpty()) {
            throw new IllegalArgumentException("O campo 'complemento' não pode ser nulo ou vazio.");
        }
    }
}
