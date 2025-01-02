package com.example.sunbridgejava.controller;

import java.util.List;

import com.example.sunbridgejava.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.sunbridgejava.service.ClienteService;

/**
 * Controlador REST para operações relacionadas a Cliente.
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    /**
     * Serviço para acessar e manipular dados de Cliente.
     */
    @Autowired
    private ClienteService s;

    /**
     * Obtém todos os clientes.
     *
     * @return ResponseEntity contendo a lista de todos os clientes.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/all")
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> clientes = s.findAll();
        return ResponseEntity.ok(clientes);
    }

    /**
     * Obtém um cliente pelo ID.
     *
     * @param id ID do cliente a ser buscado.
     * @return ResponseEntity contendo o cliente correspondente ou código 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/id/{id}")
    public ResponseEntity<Cliente> getOne(@PathVariable("id") Integer id) {
        Cliente cliente = s.findById(id).orElse(null);

        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    /**
     * Procura clientes pelo nome.
     *
     * @param name Nome ou parte do nome do cliente a ser buscado.
     * @return ResponseEntity contendo a lista de clientes que correspondem ao nome fornecido.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/name/{name}")
    public ResponseEntity<List<Cliente>> findByName(@PathVariable("name") String name) {
        List<Cliente> clientes = s.findByName(name);
        return ResponseEntity.ok(clientes);
    }

    /**
     * Deleta um cliente pelo ID.
     *
     * @param id ID do cliente a ser deletado.
     * @return ResponseEntity com código 204 se deletado com sucesso ou 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        s.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Atualiza um cliente existente pelo ID.
     *
     * @param id                ID do cliente a ser atualizado.
     * @param clienteAtualizado Objeto Cliente com os dados atualizados.
     * @return ResponseEntity contendo o cliente atualizado ou código 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<Cliente> updateCliente(
            @PathVariable int id,
            @RequestBody Cliente clienteAtualizado) {
        return s.update(id, clienteAtualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Insere um novo cliente no sistema.
     *
     * @param cliente Dados do novo cliente a ser inserido.
     * @return ResponseEntity contendo o cliente criado com código 201 ou erro 400 se houver falha.
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/insert")
    public ResponseEntity<Object> create(@RequestBody Cliente cliente) {
        try {
            Cliente novoCliente = s.create(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO: " + e.getMessage());
        }
    }

}
