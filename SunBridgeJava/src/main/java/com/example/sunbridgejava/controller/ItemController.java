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

import com.example.sunbridgejava.model.Item;
import com.example.sunbridgejava.service.ItemService;

/**
 * Controlador REST para operações relacionadas ao Item.
 */
@RestController
@RequestMapping("/item")
public class ItemController {

    /**
     * Serviço para acessar e manipular dados de Item.
     */
    @Autowired
    private ItemService s;

    /**
     * Obtém todos os registros de Item.
     *
     * @return ResponseEntity contendo a lista de todos os Items.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/all")
    public ResponseEntity<List<Item>> findAll() {
        List<Item> items = s.findAll();
        return ResponseEntity.ok(items);
    }

    /**
     * Obtém um Item pelo ID.
     *
     * @param id ID do Item a ser buscado.
     * @return ResponseEntity contendo o Item correspondente ou código 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/id/{id}")
    public ResponseEntity<Optional<Item>> getOne(@PathVariable("id") int id) {
        try {
            Optional<Item> item = s.findById(id);
            return ResponseEntity.ok(item);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Deleta um Item pelo ID.
     *
     * @param id ID do Item a ser deletado.
     * @return ResponseEntity com código 204 se deletado com sucesso ou 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        s.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Atualiza um Item existente pelo ID.
     *
     * @param id                ID do Item a ser atualizado.
     * @param itemAtualizado    Objeto Item com os dados atualizados.
     * @return ResponseEntity contendo o Item atualizado ou código 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<Item> update(
            @PathVariable int id,
            @RequestBody Item itemAtualizado) {
        return s.update(id, itemAtualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo Item.
     *
     * @param item Dados do novo Item a ser criado.
     * @return ResponseEntity contendo o Item criado com código 201 ou mensagem de erro 400 se houver falha.
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/insert")
    public ResponseEntity<Object> create(@RequestBody Item item) {
        try {
            Item novoItem = s.create(item);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoItem);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO: " + e.getMessage());
        }
    }
}
