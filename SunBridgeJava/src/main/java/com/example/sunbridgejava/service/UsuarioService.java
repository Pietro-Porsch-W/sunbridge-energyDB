package com.example.sunbridgejava.service;

import com.example.sunbridgejava.model.Empresa;
import com.example.sunbridgejava.model.Usuario;
import com.example.sunbridgejava.repository.EmpresaRepository;
import com.example.sunbridgejava.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Serviço para gerenciar operações relacionadas à entidade {@link Usuario}.
 * Este serviço contém lógica de negócio e interage com o repositório {@link UsuarioRepository}.
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository r;

    @Autowired
    private EmpresaRepository empresaRepository;

    /**
     * Deleta um usuário pelo ID.
     *
     * @param id ID do usuário a ser deletado.
     */
    public void deleteById(int id) {
        System.out.println("Delete Usuario pelo id: " + id);
        r.deleteById(id);
    }

    /**
     * Busca um usuário pelo ID.
     *
     * @param id ID do usuário.
     * @return Um {@link Optional} contendo o usuário encontrado.
     * @throws NoSuchElementException Se o usuário não for encontrado.
     */
    public Optional<Usuario> findById(int id) {
        System.out.println("Pesquisa Usuario pelo id: " + id);
        return Optional.ofNullable(r.findById(id).map(usuario -> {
            usuario.setSenha(null); // Remove a senha antes de retornar.
            return usuario;
        }).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado com o ID: " + id)));
    }

    /**
     * Retorna todos os usuários cadastrados.
     *
     * @return Lista de usuários com as senhas omitidas.
     */
    public List<Usuario> findAll() {
        System.out.println("Pesquisa Usuario todos");
        List<Usuario> usuarios = r.findAll();
        usuarios.forEach(usuario -> usuario.setSenha(null));
        return usuarios;
    }

    /**
     * Busca usuários por nome, ignorando diferenças de maiúsculas e minúsculas.
     *
     * @param nome Nome ou parte do nome do usuário.
     * @return Lista de usuários correspondentes.
     */
    public List<Usuario> findByName(String nome) {
        System.out.println("Pesquisa Usuario pelo nome contendo: " + nome);
        List<Usuario> usuarios = r.findByNomeContainingIgnoreCase(nome);
        usuarios.forEach(usuario -> usuario.setSenha(null));
        return usuarios;
    }

    /**
     * Realiza a autenticação de um usuário.
     *
     * @param usuarioID ID do usuário.
     * @param senha     Senha fornecida.
     * @return {@code true} se a autenticação for bem-sucedida, {@code false} caso contrário.
     */
    public boolean loginUser(int usuarioID, String senha) {
        return r.findById(usuarioID)
                .map(usuario -> usuario.getSenha().equals(senha))
                .orElse(false); // Retorna false se o ID não for encontrado.
    }

    /**
     * Atualiza os dados de um usuário existente.
     *
     * @param usuarioID        ID do usuário a ser atualizado.
     * @param usuarioAtualizado Objeto {@link Usuario} contendo os novos dados.
     * @return Um {@link Optional} contendo o usuário atualizado.
     */
    public Optional<Usuario> updateUsuario(int usuarioID, Usuario usuarioAtualizado) {
        System.out.println("Update Usuario pelo id: " + usuarioID);
        return r.findById(usuarioID).map(usuarioExistente -> {
            if (usuarioAtualizado.getNome() != null) usuarioExistente.setNome(usuarioAtualizado.getNome());
            if (usuarioAtualizado.getEmail() != null) usuarioExistente.setEmail(usuarioAtualizado.getEmail());
            if (usuarioAtualizado.getTelefone() != null) usuarioExistente.setTelefone(usuarioAtualizado.getTelefone());
            if (usuarioAtualizado.getRua() != null) usuarioExistente.setRua(usuarioAtualizado.getRua());
            if (usuarioAtualizado.getBairro() != null) usuarioExistente.setBairro(usuarioAtualizado.getBairro());
            if (usuarioAtualizado.getCidade() != null) usuarioExistente.setCidade(usuarioAtualizado.getCidade());
            if (usuarioAtualizado.getCanton() != null) usuarioExistente.setCanton(usuarioAtualizado.getCanton());
            if (usuarioAtualizado.getDistrito() != null) usuarioExistente.setDistrito(usuarioAtualizado.getDistrito());
            if (usuarioAtualizado.getComplemento() != null) usuarioExistente.setComplemento(usuarioAtualizado.getComplemento());
            if (usuarioAtualizado.getDepartamento() != null) usuarioExistente.setDepartamento(usuarioAtualizado.getDepartamento());
            if (usuarioAtualizado.getData_nascimento() != null) usuarioExistente.setData_nascimento(usuarioAtualizado.getData_nascimento());
            if (usuarioAtualizado.getData_admissao() != null) usuarioExistente.setData_admissao(usuarioAtualizado.getData_admissao());
            if (usuarioAtualizado.getData_entrada() != null) usuarioExistente.setData_entrada(usuarioAtualizado.getData_entrada());
            if (usuarioAtualizado.getCedula() != null) usuarioExistente.setCedula(usuarioAtualizado.getCedula());
            if (usuarioAtualizado.getSenha() != null) usuarioExistente.setSenha(usuarioAtualizado.getSenha());
            if (usuarioAtualizado.getAtivo() != usuarioExistente.getAtivo()) usuarioExistente.setAtivo(usuarioAtualizado.getAtivo());
            if (usuarioAtualizado.getSalario() > 0) usuarioExistente.setSalario(usuarioAtualizado.getSalario());
            if (usuarioAtualizado.getTipo() != 0) usuarioExistente.setTipo(usuarioAtualizado.getTipo());
            if (usuarioAtualizado.getCodigo_postal() > 0) usuarioExistente.setCodigo_postal(usuarioAtualizado.getCodigo_postal());

            return r.save(usuarioExistente);
        });
    }

    /**
     * Cria um novo usuário.
     *
     * @param usuario Objeto {@link Usuario} contendo os dados do novo usuário.
     * @return O usuário criado.
     * @throws IllegalArgumentException Se houver validações que falhem.
     */
    public Usuario create(Usuario usuario) {
        System.out.println("Create Usuario");
        validaNulo(usuario);

        if (usuario.getSenha().length() < 3) {
            throw new IllegalArgumentException("A senha deve ter pelo menos 3 caracteres.");
        }

        if (usuario.getGenero() != 'F' && usuario.getGenero() != 'M') {
            throw new IllegalArgumentException("O gênero deve ser 'F' ou 'M'.");
        }

        Empresa empresa = empresaRepository.findById(usuario.getCompanyID().getCompanyID())
                .orElseThrow(() -> new IllegalArgumentException("Empresa associada (companyID) não encontrada."));

        usuario.setAtivo(true);
        usuario.setCompanyID(empresa);

        return r.save(usuario);
    }

    /**
     * Valida os campos obrigatórios de um usuário.
     *
     * @param usuario Objeto {@link Usuario} a ser validado.
     * @throws IllegalArgumentException Se algum campo obrigatório estiver ausente ou inválido.
     */
    private void validaNulo(Usuario usuario) {
        if (usuario.getCompanyID() == null) {
            throw new IllegalArgumentException("O campo 'companyID' não pode ser nulo.");
        }
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new IllegalArgumentException("O campo 'nome' não pode ser nulo ou vazio.");
        }
        if (usuario.getGenero() == '\0') {
            throw new IllegalArgumentException("O campo 'genero' não pode ser nulo.");
        }
        if (usuario.getDepartamento() == null || usuario.getDepartamento().isEmpty()) {
            throw new IllegalArgumentException("O campo 'departamento' não pode ser nulo ou vazio.");
        }
        if (usuario.getData_admissao() == null) {
            throw new IllegalArgumentException("O campo 'data_admissao' não pode ser nulo.");
        }
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new IllegalArgumentException("O campo 'email' não pode ser nulo ou vazio.");
        }
        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new IllegalArgumentException("O campo 'senha' não pode ser nulo ou vazio.");
        }
        if (usuario.getRua() == null || usuario.getRua().isEmpty()) {
            throw new IllegalArgumentException("O campo 'rua' não pode ser nulo ou vazio.");
        }
        if (usuario.getBairro() == null || usuario.getBairro().isEmpty()) {
            throw new IllegalArgumentException("O campo 'bairro' não pode ser nulo ou vazio.");
        }
        if (usuario.getCidade() == null || usuario.getCidade().isEmpty()) {
            throw new IllegalArgumentException("O campo 'cidade' não pode ser nulo ou vazio.");
        }
        if (usuario.getCanton() == null || usuario.getCanton().isEmpty()) {
            throw new IllegalArgumentException("O campo 'canton' não pode ser nulo ou vazio.");
        }
        if (usuario.getDistrito() == null || usuario.getDistrito().isEmpty()) {
            throw new IllegalArgumentException("O campo 'distrito' não pode ser nulo ou vazio.");
        }
        if (usuario.getCodigo_postal() == 0) {
            throw new IllegalArgumentException("O campo 'codigo_postal' não pode ser nulo.");
        }
    }
}
