package com.example.sunbridgejava.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.example.sunbridgejava.model.Cliente_logistica;
import com.example.sunbridgejava.service.Cliente_logisticaService;

/**
 * Controlador REST para operações relacionadas a Cliente_logistica.
 */
@RestController
@RequestMapping("/cliente_logistica")
public class Cliente_logisticaController {

    /**
     * Serviço para acessar e manipular dados de Cliente_logistica.
     */
    @Autowired
    private Cliente_logisticaService s;

    /**
     * Obtém todos os registros de Cliente_logistica.
     *
     * @return ResponseEntity contendo a lista de todos os Cliente_logistica.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/all")
    public ResponseEntity<List<Cliente_logistica>> findAll() {
        List<Cliente_logistica> clienteLogisticas = s.findAll();
        return ResponseEntity.ok(clienteLogisticas);
    }

    /**
     * Obtém um Cliente_logistica pelo ID.
     *
     * @param id ID do Cliente_logistica a ser buscado.
     * @return ResponseEntity contendo o Cliente_logistica correspondente ou
     *         código 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/id/{id}")
    public ResponseEntity<Cliente_logistica> getOne(@PathVariable("id") int id) {
        Cliente_logistica clienteLogistica = s.findById(id).orElse(null);
        if (clienteLogistica == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteLogistica);
    }

    /**
     * Procura Cliente_logistica pelo nome.
     *
     * @param name Nome ou parte do nome do Cliente_logistica.
     * @return ResponseEntity contendo a lista de Cliente_logistica que correspondem
     *         ao nome fornecido.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/name/{name}")
    public ResponseEntity<List<Cliente_logistica>> findByName(@PathVariable("name") String name) {
        List<Cliente_logistica> clienteLogisticas = s.findByName(name);
        return ResponseEntity.ok(clienteLogisticas);
    }

    /**
     * Deleta um Cliente_logistica pelo ID.
     *
     * @param id ID do Cliente_logistica a ser deletado.
     * @return ResponseEntity com código 204 se deletado com sucesso ou 404 se não
     *         encontrado.
     */
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        s.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Atualiza um Cliente_logistica existente pelo ID.
     *
     * @param id         ID do Cliente_logistica a ser atualizado.
     * @param atualizado Dados atualizados do Cliente_logistica.
     * @return ResponseEntity contendo o Cliente_logistica atualizado ou 404 se não
     *         encontrado.
     */
    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<Cliente_logistica> update(
            @PathVariable int id,
            @RequestBody Cliente_logistica atualizado) {
        return s.update(id, atualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Insere um novo registro de Cliente_logistica.
     *
     * @param pedido Dados do novo Cliente_logistica.
     * @return ResponseEntity contendo o Cliente_logistica criado com código 201 ou
     *         erro 400 se houver falha.
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/insert")
    public ResponseEntity<Object> create(@RequestBody Cliente_logistica pedido) {
        try {
            Cliente_logistica novoPedido = s.create(pedido);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO: " + e.getMessage());
        }
    }
}
