package com.example.sunbridgejava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.sunbridgejava.model.Pedido_venda;
import com.example.sunbridgejava.service.Pedido_vendaService;

/**
 * Controlador REST para operações relacionadas à entidade {@link Pedido_venda}.
 * 
 * Todos que tiverem o começo como "/pedido_venda" caem aqui.
 */
@RestController
@RequestMapping("/pedido_venda")
public class Pedido_vendaController {

    /**
     * Serviço para acessar e manipular dados de {@link Pedido_venda}.
     */
    @Autowired
    private Pedido_vendaService s;

    /**
     * Obtém todos os registros de {@link Pedido_venda}.
     *
     * @return {@link ResponseEntity} contendo a lista de todos os pedidos com status 200 OK.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/all")
    public ResponseEntity<List<Pedido_venda>> findAll() {
        List<Pedido_venda> pedidos = s.findAll(); // Busca todos os registros
        return ResponseEntity.ok(pedidos); // Retorna a lista de registros com status 200 OK
    }

    /**
     * Obtém um {@link Pedido_venda} pelo ID.
     *
     * @param id ID do pedido a ser buscado.
     * @return {@link ResponseEntity} contendo o {@link Pedido_venda} correspondente ou 
     *         código 404 Not Found se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/id/{id}")
    public ResponseEntity<Pedido_venda> getOne(@PathVariable("id") int id) {
        Pedido_venda pedido = s.findById(id).orElse(null); // Busca o registro pelo ID
        if (pedido == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found se não encontrar
        }
        return ResponseEntity.ok(pedido); // Retorna o registro encontrado com status 200 OK
    }

    /*
    /**
     * Procura pedidos de venda pelo ID do cliente.
     *
     * @param clienteID ID do cliente a ser buscado.
     * @return Lista de pedidos de venda que correspondem ao cliente fornecido.
     */
    /*
    @CrossOrigin(origins = "*")
    @GetMapping("/findbycliente/{clienteID}")
    public ResponseEntity<List<Pedido_venda>> findByCliente(@PathVariable("clienteID") String clienteID) {
        List<Pedido_venda> pedidos = s.findByClienteIDContaining(clienteID); // Busca registros pelo clienteID
        return ResponseEntity.ok(pedidos); // Retorna a lista de registros encontrados
    }
    */

    /**
     * Deleta um {@link Pedido_venda} pelo ID.
     *
     * @param id ID do pedido a ser deletado.
     * @return {@link ResponseEntity} com código 204 No Content se deletado com sucesso ou 
     *         404 Not Found se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        s.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Atualiza um {@link Pedido_venda} existente pelo ID.
     *
     * @param id               ID do pedido a ser atualizado.
     * @param pagamentoAtualizado Objeto {@link Pedido_venda} com os dados atualizados.
     * @return {@link ResponseEntity} contendo o {@link Pedido_venda} atualizado ou 
     *         código 404 Not Found se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<Pedido_venda> update(
            @PathVariable int id,
            @RequestBody Pedido_venda pagamentoAtualizado) {
        return s.update(id, pagamentoAtualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo {@link Pedido_venda}.
     *
     * @param pedido Dados do novo pedido a ser criado.
     * @return {@link ResponseEntity} contendo o {@link Pedido_venda} criado com 
     *         código 201 Created ou mensagem de erro 400 Bad Request se houver falha.
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/insert")
    public ResponseEntity<Object> create(@RequestBody Pedido_venda pedido) {
        try {
            Pedido_venda novoPedido = s.create(pedido);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido); // Retorna 201 Created com o pedido criado
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO: " + e.getMessage()); // Retorna 400 Bad Request em caso de erro
        }
    }
}
