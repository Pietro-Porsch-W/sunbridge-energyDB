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
import com.example.sunbridgejava.model.Empresa;
import com.example.sunbridgejava.service.EmpresaService;

/**
 * Controlador REST para operações relacionadas a Empresa.
 */
@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService s;

    /**
     * Obtém todas as empresas.
     *
     * @return Lista de todas as empresas.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/all")
    public ResponseEntity<List<Empresa>> findAll() {
        List<Empresa> empresas = s.findAll();
        return ResponseEntity.ok(empresas);
    }

    /**
     * Obtém uma empresa pelo ID.
     *
     * @param id ID da empresa.
     * @return Empresa correspondente ou 404 se não encontrada.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/id/{id}")
    public ResponseEntity<Optional<Empresa>> getOne(@PathVariable("id") int id) {
        try {
            Optional<Empresa> empresa = s.findById(id);
            return ResponseEntity.ok(empresa);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Deleta uma empresa pelo ID.
     *
     * @param id ID da empresa a ser deletada.
     * @return Resposta sem conteúdo se deletada, ou 404 se não encontrada.
     */
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        try {
            s.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERRO: Empresa não encontrada com o ID: " + id);
        }
    }

    /**
     * Atualiza uma empresa existente.
     *
     * @param id           ID da empresa a ser atualizada.
     * @param atualizada   Dados atualizados da empresa.
     * @return Empresa atualizada ou 404 se não encontrada.
     */
    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<Empresa> update(@PathVariable int id, @RequestBody Empresa atualizada) {
        return s.update(id, atualizada)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    /**
     * Insere uma nova empresa.
     *
     * @param empresa Dados da nova empresa.
     * @return Empresa criada ou erro de validação.
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/insert")
    public ResponseEntity<Object> create(@RequestBody Empresa empresa) {
        try {
            Empresa novaEmpresa = s.create(empresa);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaEmpresa);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO: " + e.getMessage());
        }
    }
}
