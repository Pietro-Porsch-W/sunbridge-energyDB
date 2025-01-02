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

import com.example.sunbridgejava.model.Fornecedor;
import com.example.sunbridgejava.service.FornecedorService;

/**
 * Controlador REST para operações relacionadas a Fornecedor.
 */
@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    /**
     * Serviço para acessar e manipular dados de Fornecedor.
     */
    @Autowired
    private FornecedorService s;

    /**
     * Obtém todos os registros de Fornecedor.
     *
     * @return ResponseEntity contendo a lista de todos os fornecedores.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/all")
    public ResponseEntity<List<Fornecedor>> findAll() {
        List<Fornecedor> fornecedores = s.findAll();
        return ResponseEntity.ok(fornecedores);
    }

    /**
     * Obtém um Fornecedor pelo ID.
     *
     * @param id ID do Fornecedor a ser buscado.
     * @return ResponseEntity contendo o Fornecedor correspondente ou código 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/id/{id}")
    public ResponseEntity<Optional<Fornecedor>> getOne(@PathVariable("id") int id) {
        try {
            Optional<Fornecedor> fornecedor = s.findById(id);
            return ResponseEntity.ok(fornecedor);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Deleta um Fornecedor pelo ID.
     *
     * @param id ID do Fornecedor a ser deletado.
     * @return ResponseEntity com código 204 se deletado com sucesso ou 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        s.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Atualiza um Fornecedor existente pelo ID.
     *
     * @param id          ID do Fornecedor a ser atualizado.
     * @param atualizado  Dados atualizados do Fornecedor.
     * @return ResponseEntity contendo o Fornecedor atualizado ou código 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<Fornecedor> update(
            @PathVariable int id,
            @RequestBody Fornecedor atualizado) {
        return s.update(id, atualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo Fornecedor.
     *
     * @param fornecedor Dados do novo Fornecedor a ser criado.
     * @return ResponseEntity contendo o Fornecedor criado com código 201 ou mensagem de erro 400 se houver falha.
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/insert")
    public ResponseEntity<Object> create(@RequestBody Fornecedor fornecedor) {
        try {
            Fornecedor novoFornecedor = s.create(fornecedor);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoFornecedor);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO: " + e.getMessage());
        }
    }
}