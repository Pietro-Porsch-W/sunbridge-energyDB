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

import com.example.sunbridgejava.model.Pagamento_fornecedor;
import com.example.sunbridgejava.service.Pagamento_fornecedorService;

/**
 * Controlador REST para operações relacionadas a Pagamento_fornecedor.
 */
@RestController
@RequestMapping("/pagamento_fornecedor")
public class Pagamento_fornecedorController {

    /**
     * Serviço para acessar e manipular dados de Pagamento_fornecedor.
     */
    @Autowired
    private Pagamento_fornecedorService s;

    /**
     * Obtém todos os registros de Pagamento_fornecedor.
     *
     * @return ResponseEntity contendo a lista de todos os pagamentos de fornecedores.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/all")
    public ResponseEntity<List<Pagamento_fornecedor>> findAll() {
        List<Pagamento_fornecedor> pagamentos = s.findAll();
        return ResponseEntity.ok(pagamentos);
    }

    /**
     * Obtém um pagamento de fornecedor pelo ID.
     *
     * @param id ID do pagamento a ser buscado.
     * @return ResponseEntity contendo o Pagamento_fornecedor correspondente ou código 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/id/{id}")
    public ResponseEntity<Optional<Pagamento_fornecedor>> getOne(@PathVariable("id") int id) {
        try {
            Optional<Pagamento_fornecedor> pagamento = s.findById(id);
            return ResponseEntity.ok(pagamento);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Deleta um pagamento de fornecedor pelo ID.
     *
     * @param id ID do pagamento a ser deletado.
     * @return ResponseEntity com código 204 se deletado com sucesso ou 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        s.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Atualiza um pagamento de fornecedor existente pelo ID.
     *
     * @param id                  ID do pagamento a ser atualizado.
     * @param pagamentoAtualizado Objeto Pagamento_fornecedor com os dados atualizados.
     * @return ResponseEntity contendo o Pagamento_fornecedor atualizado ou código 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<Pagamento_fornecedor> update(
            @PathVariable int id,
            @RequestBody Pagamento_fornecedor pagamentoAtualizado) {
        return s.update(id, pagamentoAtualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo pagamento de fornecedor.
     *
     * @param pagamento Dados do novo pagamento a ser criado.
     * @return ResponseEntity contendo o Pagamento_fornecedor criado com código 201 ou mensagem de erro 400 se houver falha.
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/insert")
    public ResponseEntity<Object> create(@RequestBody Pagamento_fornecedor pagamento) {
        try {
            Pagamento_fornecedor novoPagamento = s.create(pagamento);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoPagamento);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO: " + e.getMessage());
        }
    }
}
