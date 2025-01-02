package com.example.sunbridgejava.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sunbridgejava.model.Pedido_compra;
import com.example.sunbridgejava.service.Pedido_compraService;

/**
 * Controlador REST para operações relacionadas à entidade {@link Pedido_compra}.
 * 
 * Todos que tiverem o começo como "/pedido_compra" caem aqui.
 */
@RestController
@RequestMapping("/pedido_compra")
public class Pedido_compraController {

    /**
     * Serviço para acessar e manipular dados de {@link Pedido_compra}.
     */
    @Autowired
    private Pedido_compraService s;

    /**
     * Obtém todos os registros de {@link Pedido_compra}.
     *
     * @return {@link ResponseEntity} contendo a lista de todos os pedidos com status 200 OK.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/all")
    public ResponseEntity<List<Pedido_compra>> findAll() {
        List<Pedido_compra> pedidos = s.findAll(); // Busca todos os registros
        return ResponseEntity.ok(pedidos); // Retorna a lista de registros com status 200 OK
    }

    /**
     * Obtém um {@link Pedido_compra} pelo ID.
     *
     * @param id ID do pedido a ser buscado.
     * @return {@link ResponseEntity} contendo o {@link Pedido_compra} correspondente ou 
     *         código 404 Not Found se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/id/{id}")
    public ResponseEntity<Pedido_compra> getOne(@PathVariable("id") int id) {
        Pedido_compra pedido = s.findById(id).orElse(null); // Busca o registro pelo ID
        if (pedido == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found se não encontrar
        }
        return ResponseEntity.ok(pedido); // Retorna o registro encontrado com status 200 OK
    }

    /*
    /**
     * Procura pedidos de compra pelo usuário.
     *
     * @param usuarioID ID do usuário a ser buscado.
     * @return Lista de pedidos de compra que correspondem ao usuário fornecido.
     */
    /*
    @CrossOrigin(origins = "*")
    @GetMapping("/findbyusuario/{usuarioID}")
    public ResponseEntity<List<Pedido_compra>> findByUsuario(@PathVariable("usuarioID") String usuarioID) {
        List<Pedido_compra> pedidos = s.findByUsuarioIDContaining(usuarioID); // Busca registros pelo usuarioID
        return ResponseEntity.ok(pedidos); // Retorna a lista de registros encontrados
    }
    */

    /**
     * Deleta um {@link Pedido_compra} pelo ID.
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
     * Atualiza um {@link Pedido_compra} existente pelo ID.
     *
     * @param id                ID do pedido a ser atualizado.
     * @param pagamentoAtualizado Objeto {@link Pedido_compra} com os dados atualizados.
     * @return {@link ResponseEntity} contendo o {@link Pedido_compra} atualizado ou 
     *         código 404 Not Found se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<Pedido_compra> update(
            @PathVariable int id,
            @RequestBody Pedido_compra pagamentoAtualizado) {
        return s.update(id, pagamentoAtualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo {@link Pedido_compra}.
     *
     * @param pedido Dados do novo pedido a ser criado.
     * @return {@link ResponseEntity} contendo o {@link Pedido_compra} criado com 
     *         código 201 Created ou mensagem de erro 400 Bad Request se houver falha.
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/insert")
    public ResponseEntity<Object> create(@RequestBody Pedido_compra pedido) {
        try {
            Pedido_compra novoPedido = s.create(pedido);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido); // Retorna 201 Created com o pedido criado
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO: " + e.getMessage()); // Retorna 400 Bad Request em caso de erro
        }
    }
}
