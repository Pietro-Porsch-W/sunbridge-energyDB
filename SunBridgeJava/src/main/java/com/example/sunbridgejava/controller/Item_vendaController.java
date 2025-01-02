package com.example.sunbridgejava.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

import com.example.sunbridgejava.model.Item_venda;
import com.example.sunbridgejava.service.Item_vendaService;

/**
 * Controlador REST para operações relacionadas ao Item_venda.
 */
@RestController
@RequestMapping("/item_venda")
public class Item_vendaController {

    /**
     * Serviço para acessar e manipular dados de Item_venda.
     */
    @Autowired
    private Item_vendaService s;

    /**
     * Obtém todos os registros de Item_venda.
     *
     * @return ResponseEntity contendo a lista de todos os Item_venda.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/all")
    public ResponseEntity<List<Item_venda>> findAll() {
        List<Item_venda> itemsVenda = s.findAll();
        return ResponseEntity.ok(itemsVenda);
    }

    /**
     * Obtém um Item_venda pelo ID.
     *
     * @param id ID do Item_venda a ser buscado.
     * @return ResponseEntity contendo o Item_venda correspondente ou código 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/id/{id}")
    public ResponseEntity<Optional<Item_venda>> getOne(@PathVariable("id") int id) {
        try {
            Optional<Item_venda> itemVenda = s.findById(id);
            return ResponseEntity.ok(itemVenda);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Deleta um Item_venda pelo ID.
     *
     * @param id ID do Item_venda a ser deletado.
     * @return ResponseEntity com código 204 se deletado com sucesso ou 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        s.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Atualiza um Item_venda existente pelo ID.
     *
     * @param id               ID do Item_venda a ser atualizado.
     * @param itemVendaAtualizado Objeto Item_venda com os dados atualizados.
     * @return ResponseEntity contendo o Item_venda atualizado ou código 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<Item_venda> update(
            @PathVariable int id,
            @RequestBody Item_venda itemVendaAtualizado) {
        return s.update(id, itemVendaAtualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo Item_venda.
     *
     * @param itemVenda Dados do novo Item_venda a ser criado.
     * @return ResponseEntity contendo o Item_venda criado com código 201 ou mensagem de erro 400 se houver falha.
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/insert")
    public ResponseEntity<Object> create(@RequestBody Item_venda itemVenda) {
        try {
            Item_venda novoItemVenda = s.create(itemVenda);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoItemVenda);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO: " + e.getMessage());
        }
    }
}
