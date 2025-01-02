package com.example.sunbridgejava.dao;

import java.util.List;

import com.example.sunbridgejava.model.Cliente;
import com.example.sunbridgejava.repository.UsuarioRepository;
import com.example.sunbridgejava.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 * DAO (Data Access Object) para operações relacionadas à entidade {@link Cliente}.
 * 
 * <p>
 * Esta classe fornece métodos para realizar operações CRUD (Create, Read, Update, Delete) na entidade {@code Cliente}.
 * No entanto, ela está {@code @deprecated} e não deve mais ser utilizada. Recomenda-se utilizar a interface 
 * {@link UsuarioRepository} do Spring Data JPA para acesso a dados.
 * </p>
 * 
 * @deprecated A partir da versão 2.0, {@link DaoCliente} está obsoleta e será removida em versões futuras.
 *             Utilize {@link UsuarioRepository} em seu lugar.
 * @since 1.0
 */
@Deprecated
public class DaoCliente {
    
    /**
     * Gerenciador de entidades para operações de persistência.
     */
    private EntityManager em;
    
    /**
     * Construtor padrão que inicializa o {@link EntityManager}.
     */
    public DaoCliente() {
        em = JPAUtil.getEntityManager();
    }
    
    // Métodos privados
    
    /**
     * Inicia uma transação.
     *
     * @return A instância atual de {@link DaoCliente} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoCliente abreTrans() {
        em.getTransaction().begin();
        return this;
    }
    
    /**
     * Finaliza uma transação.
     *
     * @return A instância atual de {@link DaoCliente} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoCliente fechaTrans() {
        em.getTransaction().commit();
        return this;
    }
    
    /**
     * Persiste uma entidade {@link Cliente} no banco de dados.
     *
     * @param c A entidade {@link Cliente} a ser persistida.
     * @return A instância atual de {@link DaoCliente} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoCliente incluir(Cliente c) {
        em.persist(c);
        return this;
    }
    
    /**
     * Remove uma entidade {@link Cliente} do banco de dados.
     *
     * @param c A entidade {@link Cliente} a ser removida.
     * @return A instância atual de {@link DaoCliente} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoCliente remover(Cliente c) {
        em.remove(c);
        return this;
    }

    /**
     * Atualiza uma entidade {@link Cliente} no banco de dados.
     *
     * @param c A entidade {@link Cliente} a ser atualizada.
     * @return A instância atual de {@link DaoCliente} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoCliente atualizar(Cliente c) {
        em.merge(c);
        return this;
    }
    
    // Métodos públicos
    
    /**
     * Salva uma entidade {@link Cliente} no banco de dados.
     * 
     * <p>
     * Se o {@code clienteID} for menor ou igual a zero, a entidade será persistida como uma nova entrada.
     * Caso contrário, a entidade existente será atualizada.
     * </p>
     *
     * @param c A entidade {@link Cliente} a ser salva.
     * @return A instância atual de {@link DaoCliente} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoCliente salvar(Cliente c) {
        if (c.getClienteID() <= 0) { // Verifica se o cliente ainda não foi inserido
            return this.abreTrans().incluir(c).fechaTrans();
        } else { // Se já existir, atualiza
            return this.abreTrans().atualizar(c).fechaTrans();
        }
    }
    
    /**
     * Exclui uma entidade {@link Cliente} do banco de dados.
     *
     * @param c A entidade {@link Cliente} a ser excluída.
     * @return A instância atual de {@link DaoCliente} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoCliente excluir(Cliente c) {
        return this.abreTrans().remover(c).fechaTrans();
    }
    
    /**
     * Obtém todos os registros de {@link Cliente} do banco de dados.
     *
     * @return Lista de todas as entidades {@link Cliente}.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Cliente> obterTodos() {
        String jpql = "SELECT c FROM Cliente c";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }
    
    /**
     * Busca uma entidade {@link Cliente} pelo seu identificador.
     *
     * @param id O identificador da entidade {@link Cliente} a ser buscada.
     * @return A entidade {@link Cliente} encontrada, ou {@code null} se não existir.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public Cliente buscarPorId(Integer id) {
        return em.find(Cliente.class, id);
    }
    
    /**
     * Busca entidades {@link Cliente} cujo nome contém a string especificada.
     *
     * @param nome Parte ou totalidade do nome a ser buscado.
     * @return Lista de entidades {@link Cliente} que correspondem ao critério de busca.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Cliente> buscarPorNome(String nome) {
        String jpql = "SELECT c FROM Cliente c WHERE c.nome LIKE :nome";
        TypedQuery<Cliente> consulta = em.createQuery(jpql, Cliente.class);
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
