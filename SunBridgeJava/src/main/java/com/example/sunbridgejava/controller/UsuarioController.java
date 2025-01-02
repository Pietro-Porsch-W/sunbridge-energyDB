package com.example.sunbridgejava.controller;

import com.example.sunbridgejava.model.Usuario;
import com.example.sunbridgejava.service.UsuarioService;
import com.example.sunbridgejava.DTO.UsuarioResponse;
import com.example.sunbridgejava.DTO.Relatorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Controlador REST para operações relacionadas à entidade {@link Usuario}.
 *
 * Todos que tiverem o começo como "/usuario" são tratados por este controlador.
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    /**
     * Serviço para acessar e manipular dados de {@link Usuario}.
     */
    @Autowired
    private UsuarioService s;

    @Autowired
    private Relatorio relatorioService;

    /**
     * Obtém todos os usuários cadastrados.
     *
     * @return {@link ResponseEntity} contendo a lista de todos os usuários com status 200 OK.
     *         Se a lista estiver vazia, retorna status 404 Not Found com a mensagem "Nenhum usuário encontrado".
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/all")
    public ResponseEntity<?> getAllUsuarios() {
        List<Usuario> usuarios = s.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum usuário encontrado.");
        }
        return ResponseEntity.ok(usuarios);
    }

    /**
     * Obtém um {@link Usuario} pelo ID.
     *
     * @param id ID do usuário a ser buscado.
     * @return {@link ResponseEntity} contendo o {@link Usuario} correspondente com status 200 OK.
     *         Se o usuário não for encontrado, retorna status 404 Not Found.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/id/{id}")
    public ResponseEntity<Optional<Usuario>> findById(@PathVariable("id") Integer id) {
        try {
            Optional<Usuario> usuario = s.findById(id);
            return ResponseEntity.ok(usuario);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Procura usuários pelo nome ou parte do nome.
     *
     * @param nome Nome ou parte do nome do usuário a ser buscado.
     * @return {@link ResponseEntity} contendo a lista de usuários que correspondem ao nome fornecido com status 200 OK.
     *         Se a lista estiver vazia, retorna status 404 Not Found.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/find/name/{nome}")
    public ResponseEntity<List<Usuario>> findByName(@PathVariable("nome") String nome) {
        List<Usuario> usuarios = s.findByName(nome);
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(usuarios);
    }

    /**
     * Deleta um {@link Usuario} pelo ID.
     *
     * @param id ID do usuário a ser deletado.
     * @return {@link ResponseEntity} contendo uma mensagem de sucesso com status 204 No Content se deletado,
     *         ou uma mensagem de erro com status 404 Not Found se o usuário não existir.
     */
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        try {
            s.deleteById(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content se deletado com sucesso
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Usuário não encontrado."); // Retorna 404 Not Found se não encontrado
        }
    }

    /**
     * Atualiza um {@link Usuario} existente pelo ID.
     *
     * @param id               ID do usuário a ser atualizado.
     * @param usuarioAtualizado Objeto {@link Usuario} com os dados atualizados.
     * @return {@link ResponseEntity} contendo o {@link Usuario} atualizado ou
     *         código 404 Not Found se não encontrado.
     */
    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<Usuario> updateUsuario(
            @PathVariable int id,
            @RequestBody Usuario usuarioAtualizado) {
        return s.updateUsuario(id, usuarioAtualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Autentica um usuário com base no {@link UsuarioResponse}.
     *
     * @param loginDTO DTO contendo o {@link Usuario}'s ID e senha para login.
     * @return {@link ResponseEntity} contendo {@code true} se a autenticação for bem-sucedida,
     *         ou {@code false} caso contrário, com status 200 OK.
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<Boolean> loginUser(@RequestBody UsuarioResponse loginDTO) {
        boolean isValid = s.loginUser(loginDTO.getUsuarioID(), loginDTO.getSenha());
        return ResponseEntity.ok(isValid);
    }

    /**
     * Cria um novo {@link Usuario}.
     *
     * @param usuario Dados do novo usuário a ser criado.
     * @return {@link ResponseEntity} contendo o {@link Usuario} criado com
     *         código 201 Created ou mensagem de erro 400 Bad Request se houver falha.
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/insert")
    public ResponseEntity<Object> createUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario novoUsuario = s.create(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario); // Retorna 201 Created com o usuário criado
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO: " + e.getMessage()); // Retorna 400 Bad Request em caso de erro
        }
    }

    /**
     * Relatório de vendas por período e por funcionário.
     *
     * Este método verifica se o usuário tem permissão para acessar o relatório. Caso tenha, ele retorna
     * as vendas realizadas no período informado, associadas ao funcionário.
     *
     * @param usuarioID ID do usuário solicitante.
     * @param inicio    Data de início do período de vendas.
     * @param fim       Data de fim do período de vendas.
     * @return {@link ResponseEntity} contendo a lista de vendas ou uma mensagem de erro em caso de falha.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/relatorio/vendas")
    public ResponseEntity<?> relatorioVendas(
            @RequestParam int usuarioID,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date inicio,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fim) {
        try {
            Usuario usuario = s.findById(usuarioID)
                    .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));
            List<?> vendas = relatorioService.relatorioVendas(usuario, (java.sql.Date) inicio, (java.sql.Date) fim);
            return ResponseEntity.ok(vendas);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    /**
     * Relatório de estoque.
     *
     * Este método verifica se o usuário tem permissão para acessar o relatório. Caso tenha, ele retorna
     * uma lista de itens disponíveis no estoque e itens abaixo do limite definido.
     *
     * @param usuarioID ID do usuário solicitante.
     * @return {@link ResponseEntity} contendo o relatório de estoque ou uma mensagem de erro em caso de falha.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/relatorio/estoque")
    public ResponseEntity<?> relatorioEstoque(@RequestParam int usuarioID) {
        try {
            Usuario usuario = s.findById(usuarioID)
                    .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));
            List<?> estoque = relatorioService.relatorioEstoque(usuario);
            return ResponseEntity.ok(estoque);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Relatório de clientes (histórico de compras e status de dívidas).
     *
     * Este método verifica se o usuário tem permissão para acessar o relatório. Caso tenha, ele retorna
     * uma lista de clientes, incluindo seus históricos de compras e status de dívidas.
     *
     * @param usuarioID ID do usuário solicitante.
     * @return {@link ResponseEntity} contendo o relatório de clientes ou uma mensagem de erro em caso de falha.
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/relatorio/clientes")
    public ResponseEntity<?> relatorioClientes(@RequestParam int usuarioID) {
        try {
            Usuario usuario = s.findById(usuarioID)
                    .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));
            List<?> clientes = relatorioService.relatorioClientes(usuario);
            return ResponseEntity.ok(clientes);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
