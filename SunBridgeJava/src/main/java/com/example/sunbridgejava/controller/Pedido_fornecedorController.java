package com.example.sunbridgejava.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.sunbridgejava.model.Pedido_fornecedor;
import com.example.sunbridgejava.service.Pedido_fornecedorService;

/**
 * Controlador REST para operações relacionadas à entidade {@link Pedido_fornecedor}.
 * 
 * Todos que tiverem o começo como "/pedido_fornecedor" caem aqui.
 */
@RestController
@RequestMapping("/pedido_fornecedor")
public class Pedido_fornecedorController {

    /**
     * Serviço para acessar e manipular dados de {@link Pedido_fornecedor}.
     */
    @Autowired
    private Pedido_fornecedorService s;

    /**
     * Obtém todos os registros de {@link Pedido_fornecedor}.
     *
     * @return {@link ResponseEntity} contendo a lista de todos os pedidos com status 200 OK.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/all")
    public ResponseEntity<List<Pedido_fornecedor>> findAll() {
        List<Pedido_fornecedor> pedidos = s.findAll(); // Busca todos os registros
        return ResponseEntity.ok(pedidos); // Retorna a lista de registros com status 200 OK
    }

    /**
     * Obtém um {@link Pedido_fornecedor} pelo ID.
     *
     * @param id ID do pedido a ser buscado.
     * @return {@link ResponseEntity} contendo o {@link Pedido_fornecedor} correspondente ou 
     *         código 404 Not Found se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/id/{id}")
    public ResponseEntity<Pedido_fornecedor> getOne(@PathVariable("id") int id) {
        Pedido_fornecedor pedido = s.findById(id).orElse(null); // Busca o registro pelo ID
        if (pedido == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found se não encontrar
        }
        return ResponseEntity.ok(pedido); // Retorna o registro encontrado com status 200 OK
    }
    
    /**
     * Deleta um {@link Pedido_fornecedor} pelo ID.
     *
     * @param id ID do pedido a ser deletado.
     * @return {@link ResponseEntity} com código 204 No Content se deletado com sucesso ou 
     *         404 Not Found se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            s.deleteById(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content se deletado com sucesso
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Pedido não encontrado."); // Retorna 404 Not Found se não encontrado
        }
    }

    /**
     * Atualiza um {@link Pedido_fornecedor} existente pelo ID.
     *
     * @param id                 ID do pedido a ser atualizado.
     * @param pagamentoAtualizado Objeto {@link Pedido_fornecedor} com os dados atualizados.
     * @return {@link ResponseEntity} contendo o {@link Pedido_fornecedor} atualizado ou 
     *         código 404 Not Found se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<Pedido_fornecedor> update(
            @PathVariable int id,
            @RequestBody Pedido_fornecedor pagamentoAtualizado) {
        return s.update(id, pagamentoAtualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo {@link Pedido_fornecedor}.
     *
     * @param pedido Dados do novo pedido a ser criado.
     * @return {@link ResponseEntity} contendo o {@link Pedido_fornecedor} criado com 
     *         código 201 Created ou mensagem de erro 400 Bad Request se houver falha.
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/insert")
    public ResponseEntity<Object> create(@RequestBody Pedido_fornecedor pedido) {
        try {
            Pedido_fornecedor novoPedido = s.create(pedido);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido); // Retorna 201 Created com o pedido criado
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO: " + e.getMessage()); // Retorna 400 Bad Request em caso de erro
        }
    }
}
