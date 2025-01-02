package com.example.sunbridgejava.service;

import com.example.sunbridgejava.model.Cliente;
import com.example.sunbridgejava.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Serviço responsável por gerenciar as operações relacionadas à entidade {@code Cliente}.
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository r;

    /**
     * Busca um cliente pelo ID.
     *
     * @param id Identificador do cliente.
     * @return Optional contendo o cliente, se encontrado.
     */
    public Optional<Cliente> findById(int id) {
        System.out.println("Pesquisa Cliente pelo ID: " + id);
        return r.findById(id).map(cliente -> {
            return cliente;
        });
    }

    /**
     * Retorna todos os clientes registrados.
     *
     * @return Lista de todos os clientes.
     */
    public List<Cliente> findAll() {
        System.out.println("Pesquisa Cliente Todos");
        return r.findAll();
    }

    /**
     * Busca uma lista de clientes com nomes que contenham o parâmetro fornecido.
     *
     * @param nome Nome parcial ou completo para busca.
     * @return Lista de clientes encontrados.
     */
    public List<Cliente> findByName(String nome) {
        System.out.println("Pesquisa Cliente pelo nome contendo: " + nome);
        return r.findByNomeContainingIgnoreCase(nome);
    }

    /**
     * Deleta um cliente pelo ID.
     *
     * @param id Identificador do cliente.
     */
    public void deleteById(int id) {
        System.out.println("Delete de Cliente pelo ID: " + id);
        r.deleteById(id);
    }

    /**
     * Atualiza as informações de um cliente existente.
     *
     * @param clienteID        Identificador do cliente.
     * @param clienteAtualizado Dados atualizados do cliente.
     * @return Optional contendo o cliente atualizado, se encontrado.
     */
    public Optional<Cliente> update(int clienteID, Cliente clienteAtualizado) {
        System.out.println("Update de Cliente pelo ID: " + clienteID);
        return r.findById(clienteID).map(clienteExistente -> {
            // Atualiza apenas os campos fornecidos no clienteAtualizado
            if (clienteAtualizado.getCedula() != null) clienteExistente.setCedula(clienteAtualizado.getCedula());
            if (clienteAtualizado.getNome() != null) clienteExistente.setNome(clienteAtualizado.getNome());
            if (clienteAtualizado.getData_nascimento() != null) clienteExistente.setData_nascimento(clienteAtualizado.getData_nascimento());
            if (clienteAtualizado.getGenero() != null) clienteExistente.setGenero(clienteAtualizado.getGenero());
            if (clienteAtualizado.getEmail() != null) clienteExistente.setEmail(clienteAtualizado.getEmail());
            if (clienteAtualizado.getTelefone() != null) clienteExistente.setTelefone(clienteAtualizado.getTelefone());
            if (clienteAtualizado.getRua() != null) clienteExistente.setRua(clienteAtualizado.getRua());
            if (clienteAtualizado.getBairro() != null) clienteExistente.setBairro(clienteAtualizado.getBairro());
            if (clienteAtualizado.getCidade() != null) clienteExistente.setCidade(clienteAtualizado.getCidade());
            if (clienteAtualizado.getProvincia() != null) clienteExistente.setProvincia(clienteAtualizado.getProvincia());
            if (clienteAtualizado.getCanton() != null) clienteExistente.setCanton(clienteAtualizado.getCanton());
            if (clienteAtualizado.getDistrito() != null) clienteExistente.setDistrito(clienteAtualizado.getDistrito());
            if (clienteAtualizado.getCodigo_postal() > 0) clienteExistente.setCodigo_postal(clienteAtualizado.getCodigo_postal());
            if (clienteAtualizado.getComplemento() != null) clienteExistente.setComplemento(clienteAtualizado.getComplemento());
            if (clienteAtualizado.getDivida() != null) clienteExistente.setDivida(clienteAtualizado.getDivida());
            if (clienteAtualizado.getUsuarioID() != null) clienteExistente.setUsuarioID(clienteAtualizado.getUsuarioID());

            // Salva no banco de dados
            return r.save(clienteExistente);
        });
    }

    /**
     * Cria um novo cliente.
     *
     * @param cliente Cliente a ser criado.
     * @return Cliente criado.
     * @throws IllegalArgumentException Caso algum campo obrigatório esteja ausente ou inválido.
     */
    public Cliente create(Cliente cliente) {
        System.out.println("Create de Cliente do ID: " + cliente.getUsuarioID());
        validaNulo(cliente);

        // Verificar se o usuarioID é fornecido e existe no banco de dados
        if (cliente.getUsuarioID() == null || !r.existsById(cliente.getUsuarioID().getUsuarioID())) {
            throw new IllegalArgumentException("O usuário associado (usuarioID) não existe.");
        }

        // Validação de gênero
        if (cliente.getGenero() != null && !cliente.getGenero().toString().equalsIgnoreCase("M") && !cliente.getGenero().toString().equalsIgnoreCase("F")) {
            throw new IllegalArgumentException("O gênero deve ser 'M' (masculino) ou 'F' (feminino).");
        }

        // Definir valor padrão para dívida
        cliente.setDivida(0.0);

        // Salvar cliente no banco
        return r.save(cliente);
    }

    /**
     * Valida os campos obrigatórios de um cliente.
     *
     * @param cliente Cliente a ser validado.
     * @throws IllegalArgumentException Caso algum campo obrigatório esteja ausente ou inválido.
     */
    private void validaNulo(Cliente cliente) {
        if (cliente.getUsuarioID() == null) {
            throw new IllegalArgumentException("O campo 'usuarioID' não pode ser nulo.");
        }
        if (cliente.getCedula() == null || cliente.getCedula().isEmpty()) {
            throw new IllegalArgumentException("O campo 'cedula' não pode ser nulo ou vazio.");
        }
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new IllegalArgumentException("O campo 'nome' não pode ser nulo ou vazio.");
        }
        if (cliente.getGenero() != 'F' && cliente.getGenero() != 'M') {
            throw new IllegalArgumentException("O campo 'genero' deve ser 'F' ou 'M'.");
        }
        if (cliente.getRua() == null || cliente.getRua().isEmpty()) {
            throw new IllegalArgumentException("O campo 'rua' não pode ser nulo ou vazio.");
        }
        if (cliente.getBairro() == null || cliente.getBairro().isEmpty()) {
            throw new IllegalArgumentException("O campo 'bairro' não pode ser nulo ou vazio.");
        }
        if (cliente.getCidade() == null || cliente.getCidade().isEmpty()) {
            throw new IllegalArgumentException("O campo 'cidade' não pode ser nulo ou vazio.");
        }
        if (cliente.getProvincia() == null || cliente.getProvincia().isEmpty()) {
            throw new IllegalArgumentException("O campo 'provincia' não pode ser nulo ou vazio.");
        }
        if (cliente.getCanton() == null || cliente.getCanton().isEmpty()) {
            throw new IllegalArgumentException("O campo 'canton' não pode ser nulo ou vazio.");
        }
        if (cliente.getDistrito() == null || cliente.getDistrito().isEmpty()) {
            throw new IllegalArgumentException("O campo 'distrito' não pode ser nulo ou vazio.");
        }
        if (cliente.getCodigo_postal() <= 0) {
            throw new IllegalArgumentException("O campo 'codigo_postal' deve ser maior que zero.");
        }
    }

}
