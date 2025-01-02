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

import com.example.sunbridgejava.model.Estoque;
import com.example.sunbridgejava.service.EstoqueService;

/**
 * Controlador REST para operações relacionadas a Estoque.
 */
@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    /**
     * Serviço para acessar e manipular dados de Estoque.
     */
    @Autowired
    private EstoqueService s;

    /**
     * Obtém todos os registros de Estoque.
     *
     * @return ResponseEntity contendo a lista de todos os Estoques.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/all")
    public ResponseEntity<List<Estoque>> findAll() {
        List<Estoque> estoques = s.findAll();
        return ResponseEntity.ok(estoques);
    }

    /**
     * Obtém um Estoque pelo ID.
     *
     * @param id ID do Estoque a ser buscado.
     * @return ResponseEntity contendo o Estoque correspondente ou código 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/id/{id}")
    public ResponseEntity<Optional<Estoque>> getOne(@PathVariable("id") int id) {
        try {
            Optional<Estoque> estoque = s.findById(id);
            return ResponseEntity.ok(estoque);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Deleta um Estoque pelo ID.
     *
     * @param id ID do Estoque a ser deletado.
     * @return ResponseEntity com código 204 se deletado com sucesso ou 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        s.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Atualiza um Estoque existente pelo ID.
     *
     * @param id          ID do Estoque a ser atualizado.
     * @param atualizado  Dados atualizados do Estoque.
     * @return ResponseEntity contendo o Estoque atualizado ou código 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<Estoque> update(
            @PathVariable int id,
            @RequestBody Estoque atualizado) {
        return s.update(id, atualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo Estoque.
     *
     * @param estoque Dados do Estoque a ser criado.
     * @return ResponseEntity contendo o Estoque criado com código 201 ou mensagem de erro 400 se houver falha.
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/insert")
    public ResponseEntity<Object> create(@RequestBody Estoque estoque) {
        try {
            Estoque novoEstoque = s.create(estoque);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoEstoque);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO: " + e.getMessage());
        }
    }
}
