package com.example.sunbridgejava.DTO;

/**
 * DTO (Data Transfer Object) para representar a resposta de autenticação de um {@link Usuario}.
 * 
 * Esta classe contém as informações necessárias para validar o login de um usuário,
 * incluindo o ID do usuário e sua senha.
 */
public class UsuarioResponse {
    
    /**
     * ID único do usuário.
     */
    private int usuarioID;
    
    /**
     * Senha do usuário para autenticação.
     */
    private String senha;

    /**
     * Obtém o ID do usuário.
     *
     * @return {@code int} representando o ID do usuário.
     */
    public int getUsuarioID() {
        return usuarioID;
    }

    /**
     * Define o ID do usuário.
     *
     * @param usuarioID {@code int} representando o novo ID do usuário.
     */
    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    /**
     * Obtém a senha do usuário.
     *
     * @return {@code String} representando a senha do usuário.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do usuário.
     *
     * @param senha {@code String} representando a nova senha do usuário.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
