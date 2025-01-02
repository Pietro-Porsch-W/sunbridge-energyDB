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

import com.example.sunbridgejava.model.Pagamento;
import com.example.sunbridgejava.service.PagamentoService;

/**
 * Controlador REST para operações relacionadas a Pagamento.
 */
@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    /**
     * Serviço para acessar e manipular dados de Pagamento.
     */
    @Autowired
    private PagamentoService s;

    /**
     * Obtém todos os registros de Pagamento.
     *
     * @return ResponseEntity contendo a lista de todos os Pagamentos.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/all")
    public ResponseEntity<List<Pagamento>> findAll() {
        List<Pagamento> pagamentos = s.findAll();
        return ResponseEntity.ok(pagamentos);
    }

    /**
     * Obtém um Pagamento pelo ID.
     *
     * @param id ID do Pagamento a ser buscado.
     * @return ResponseEntity contendo o Pagamento correspondente ou código 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/id/{id}")
    public ResponseEntity<Optional<Pagamento>> getOne(@PathVariable("id") int id) {
        try {
            Optional<Pagamento> pagamento = s.findById(id);
            return ResponseEntity.ok(pagamento);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Deleta um Pagamento pelo ID.
     *
     * @param id ID do Pagamento a ser deletado.
     * @return ResponseEntity com código 204 se deletado com sucesso ou 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            s.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Pagamento não encontrado.");
        }
    }

    /**
     * Atualiza um Pagamento existente pelo ID.
     *
     * @param id                ID do Pagamento a ser atualizado.
     * @param pagamentoAtualizado Objeto Pagamento com os dados atualizados.
     * @return ResponseEntity contendo o Pagamento atualizado ou código 404 se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<Pagamento> update(
            @PathVariable int id,
            @RequestBody Pagamento pagamentoAtualizado) {
        return s.update(id, pagamentoAtualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo Pagamento.
     *
     * @param pagamento Dados do novo Pagamento a ser criado.
     * @return ResponseEntity contendo o Pagamento criado com código 201 ou mensagem de erro 400 se houver falha.
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/insert")
    public ResponseEntity<Object> create(@RequestBody Pagamento pagamento) {
        try {
            Pagamento novoPagamento = s.create(pagamento);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoPagamento);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO: " + e.getMessage());
        }
    }
}
