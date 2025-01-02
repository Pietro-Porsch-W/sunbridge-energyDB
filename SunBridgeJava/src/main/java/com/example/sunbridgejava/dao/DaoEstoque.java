package com.example.sunbridgejava.dao;

import java.util.List;

import com.example.sunbridgejava.model.Estoque;
import com.example.sunbridgejava.repository.EstoqueRepository;
import com.example.sunbridgejava.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 * DAO (Data Access Object) para operações relacionadas à entidade {@link Estoque}.
 * 
 * <p>
 * Esta classe fornece métodos para realizar operações CRUD (Create, Read, Update, Delete) na entidade {@code Estoque}.
 * No entanto, ela está {@code @deprecated} e não deve mais ser utilizada. Recomenda-se utilizar a interface 
 * {@link EstoqueRepository} do Spring Data JPA para acesso a dados.
 * </p>
 * 
 * @deprecated A partir da versão 2.0, {@link DaoEstoque} está obsoleta e será removida em versões futuras.
 *             Utilize {@link EstoqueRepository} em seu lugar.
 * @since 1.0
 */
@Deprecated
public class DaoEstoque {
    
    /**
     * Gerenciador de entidades para operações de persistência.
     */
    private EntityManager em;
    
    /**
     * Construtor padrão que inicializa o {@link EntityManager}.
     */
    public DaoEstoque() {
        em = JPAUtil.getEntityManager();
    }
    
    // Métodos privados
    
    /**
     * Inicia uma transação.
     *
     * @return A instância atual de {@link DaoEstoque} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoEstoque abreTrans() {
        em.getTransaction().begin();
        return this;
    }
    
    /**
     * Finaliza uma transação.
     *
     * @return A instância atual de {@link DaoEstoque} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoEstoque fechaTrans() {
        em.getTransaction().commit();
        return this;
    }
    
    /**
     * Persiste uma entidade {@link Estoque} no banco de dados.
     *
     * @param e A entidade {@link Estoque} a ser persistida.
     * @return A instância atual de {@link DaoEstoque} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoEstoque incluir(Estoque e) {
        em.persist(e);
        return this;
    }
    
    /**
     * Remove uma entidade {@link Estoque} do banco de dados.
     *
     * @param e A entidade {@link Estoque} a ser removida.
     * @return A instância atual de {@link DaoEstoque} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoEstoque remover(Estoque e) {
        em.remove(e);
        return this;
    }
    
    // Métodos públicos
    
    /**
     * Salva uma entidade {@link Estoque} no banco de dados.
     * 
     * <p>
     * Se o {@code estoqueID} for menor ou igual a zero, a entidade será persistida como uma nova entrada.
     * Caso contrário, a entidade existente será atualizada.
     * </p>
     *
     * @param e A entidade {@link Estoque} a ser salva.
     * @return A instância atual de {@link DaoEstoque} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoEstoque salvar(Estoque e) {
        return this.abreTrans().incluir(e).fechaTrans();
    }
    
    /**
     * Exclui uma entidade {@link Estoque} do banco de dados.
     *
     * @param e A entidade {@link Estoque} a ser excluída.
     * @return A instância atual de {@link DaoEstoque} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoEstoque excluir(Estoque e) {
        return this.abreTrans().remover(e).fechaTrans();
    }
    
    /**
     * Obtém todos os registros de {@link Estoque} do banco de dados.
     *
     * @return Lista de todas as entidades {@link Estoque}.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Estoque> obterTodos() {
        String jpql = "SELECT e FROM Estoque e";
        return em.createQuery(jpql, Estoque.class).getResultList();
    }
    
    /**
     * Busca uma entidade {@link Estoque} pelo seu identificador.
     *
     * @param id O identificador da entidade {@link Estoque} a ser buscada.
     * @return A entidade {@link Estoque} encontrada, ou {@code null} se não existir.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public Estoque buscarPorId(Integer id) {
        return em.find(Estoque.class, id);
    }
    
    /**
     * Busca entidades {@link Estoque} cujo nome contém a string especificada.
     *
     * @param nome Parte ou totalidade do nome a ser buscado.
     * @return Lista de entidades {@link Estoque} que correspondem ao critério de busca.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Estoque> buscarPorNome(String nome) {
        String jpql = "SELECT e FROM Estoque e WHERE e.nome LIKE :nome";
        TypedQuery<Estoque> consulta = em.createQuery(jpql, Estoque.class);
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
