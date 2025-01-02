package com.example.sunbridgejava.dao;

import com.example.sunbridgejava.model.Usuario;
import com.example.sunbridgejava.repository.UsuarioRepository;
import com.example.sunbridgejava.util.JPAUtil;
import java.util.List; 
import jakarta.persistence.EntityManager; 
import jakarta.persistence.TypedQuery;

/**
 * DAO (Data Access Object) para operações relacionadas à entidade {@link Usuario}.
 * 
 * <p>
 * Esta classe fornece métodos para realizar operações CRUD (Create, Read, Update, Delete) na entidade {@code Usuario}.
 * No entanto, ela está {@code @deprecated} e não deve mais ser utilizada. Recomenda-se utilizar a interface 
 * {@link UsuarioRepository} do Spring Data JPA para acesso a dados.
 * </p>
 * 
 * @deprecated A partir da versão 2.0, {@link DaoUsuario} está obsoleta e será removida em versões futuras.
 *             Utilize {@link UsuarioRepository} em seu lugar.
 * @since 1.0
 */
@Deprecated
public class DaoUsuario {
    
    /**
     * Gerenciador de entidades para operações de persistência.
     */
    private EntityManager em;
    
    /**
     * Construtor padrão que inicializa o {@link EntityManager}.
     */
    public DaoUsuario() {
        em = JPAUtil.getEntityManager();
    }
    
    // Métodos privados
    
    /**
     * Inicia uma transação.
     *
     * @return A instância atual de {@link DaoUsuario} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoUsuario abreTrans() {
        em.getTransaction().begin();
        return this;
    }
    
    /**
     * Finaliza uma transação.
     *
     * @return A instância atual de {@link DaoUsuario} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoUsuario fechaTrans() {
        em.getTransaction().commit();
        return this;
    }
    
    /**
     * Persiste uma entidade {@link Usuario} no banco de dados.
     *
     * @param u A entidade {@link Usuario} a ser persistida.
     * @return A instância atual de {@link DaoUsuario} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoUsuario incluir(Usuario u) {
        em.persist(u);
        return this;
    }
    
    /**
     * Remove uma entidade {@link Usuario} do banco de dados.
     *
     * @param u A entidade {@link Usuario} a ser removida.
     * @return A instância atual de {@link DaoUsuario} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoUsuario remover(Usuario u) {
        em.remove(u);
        return this;
    }
    
    // Métodos públicos
    
    /**
     * Salva uma entidade {@link Usuario} no banco de dados.
     * 
     * <p>
     * Este método persiste a entidade {@code Usuario} como uma nova entrada no banco de dados.
     * Se o {@code usuarioID} for menor ou igual a zero, a entidade será persistida como uma nova entrada.
     * Caso contrário, a entidade existente será atualizada.
     * </p>
     *
     * @param u A entidade {@link Usuario} a ser salva.
     * @return A instância atual de {@link DaoUsuario} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoUsuario salvar(Usuario u) {
        // Se aplicável, implemente a lógica condicional para inclusão ou atualização
        // Exemplo:
        // if (u.getUsuarioID() <= 0) {
        //     return this.abreTrans().incluir(u).fechaTrans();
        // } else {
        //     return this.abreTrans().atualizar(u).fechaTrans();
        // }
        return this.abreTrans().incluir(u).fechaTrans();
    }
    
    /**
     * Exclui uma entidade {@link Usuario} do banco de dados.
     *
     * @param u A entidade {@link Usuario} a ser excluída.
     * @return A instância atual de {@link DaoUsuario} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoUsuario excluir(Usuario u) {
        return this.abreTrans().remover(u).fechaTrans();
    }
    
    /**
     * Obtém todos os registros de {@link Usuario} do banco de dados.
     *
     * @return Lista de todas as entidades {@link Usuario}.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Usuario> obterTodos() {
        String jpql = "SELECT u FROM Usuario u";
        return em.createQuery(jpql, Usuario.class).getResultList();
    }

    /**
     * Busca uma entidade {@link Usuario} pelo seu identificador.
     *
     * @param id O identificador da entidade {@link Usuario} a ser buscada.
     * @return A entidade {@link Usuario} encontrada, ou {@code null} se não existir.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public Usuario buscarPorId(Integer id) {
        String jpql = "SELECT u FROM Usuario u WHERE u.usuarioID = :id";
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult(); // Retorna o único resultado
        } catch (Exception e) {
            return null; // Retorna null se não encontrar nenhum usuário
        }
    }

    /**
     * Busca entidades {@link Usuario} cujo nome contém a string especificada.
     *
     * @param nome Parte ou totalidade do nome a ser buscado.
     * @return Lista de entidades {@link Usuario} que correspondem ao critério de busca.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Usuario> buscarPorNome(String nome) {
        String jpql = "SELECT u FROM Usuario u WHERE u.nome LIKE :nome";
        TypedQuery<Usuario> consulta = em.createQuery(jpql, Usuario.class);
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }
    
    /**
     * Fecha o {@link EntityManager} associado a esta instância.
     *
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public void fechar() {
        em.close();
    }
}
