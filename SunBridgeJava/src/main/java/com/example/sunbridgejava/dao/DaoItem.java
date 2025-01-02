package com.example.sunbridgejava.dao;

import java.util.List;

import com.example.sunbridgejava.model.Item;
import com.example.sunbridgejava.repository.ItemRepository;
import com.example.sunbridgejava.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 * DAO (Data Access Object) para operações relacionadas à entidade {@link Item}.
 * 
 * <p>
 * Esta classe fornece métodos para realizar operações CRUD (Create, Read, Update, Delete) na entidade {@code Item}.
 * No entanto, ela está {@code @deprecated} e não deve mais ser utilizada. Recomenda-se utilizar a interface 
 * {@link ItemRepository} do Spring Data JPA para acesso a dados.
 * </p>
 * 
 * @deprecated A partir da versão 2.0, {@link DaoItem} está obsoleta e será removida em versões futuras.
 *             Utilize {@link ItemRepository} em seu lugar.
 * @since 1.0
 */
@Deprecated
public class DaoItem {
    
    /**
     * Gerenciador de entidades para operações de persistência.
     */
    private EntityManager em;
    
    /**
     * Construtor padrão que inicializa o {@link EntityManager}.
     */
    public DaoItem() {
        em = JPAUtil.getEntityManager();
    }
    
    // Métodos privados
    
    /**
     * Inicia uma transação.
     *
     * @return A instância atual de {@link DaoItem} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoItem abreTrans() {
        em.getTransaction().begin();
        return this;
    }
    
    /**
     * Finaliza uma transação.
     *
     * @return A instância atual de {@link DaoItem} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoItem fechaTrans() {
        em.getTransaction().commit();
        return this;
    }
    
    /**
     * Persiste uma entidade {@link Item} no banco de dados.
     *
     * @param i A entidade {@link Item} a ser persistida.
     * @return A instância atual de {@link DaoItem} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoItem incluir(Item i) {
        em.persist(i);
        return this;
    }
    
    /**
     * Remove uma entidade {@link Item} do banco de dados.
     *
     * @param i A entidade {@link Item} a ser removida.
     * @return A instância atual de {@link DaoItem} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoItem remover(Item i) {
        em.remove(i);
        return this;
    }
    
    // Métodos públicos
    
    /**
     * Salva uma entidade {@link Item} no banco de dados.
     * 
     * <p>
     * Se o {@code itemID} for menor ou igual a zero, a entidade será persistida como uma nova entrada.
     * Caso contrário, a entidade existente será atualizada.
     * </p>
     *
     * @param i A entidade {@link Item} a ser salva.
     * @return A instância atual de {@link DaoItem} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoItem salvar(Item i) {
        return this.abreTrans().incluir(i).fechaTrans();
    }
    
    /**
     * Exclui uma entidade {@link Item} do banco de dados.
     *
     * @param i A entidade {@link Item} a ser excluída.
     * @return A instância atual de {@link DaoItem} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoItem excluir(Item i) {
        return this.abreTrans().remover(i).fechaTrans();
    }
    
    /**
     * Obtém todos os registros de {@link Item} do banco de dados.
     *
     * @return Lista de todas as entidades {@link Item}.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Item> obterTodos() {
        String jpql = "SELECT i FROM Item i";
        return em.createQuery(jpql, Item.class).getResultList();
    }
    
    /**
     * Busca uma entidade {@link Item} pelo seu identificador.
     *
     * @param id O identificador da entidade {@link Item} a ser buscada.
     * @return A entidade {@link Item} encontrada, ou {@code null} se não existir.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public Item buscarPorId(Integer id) {
        return em.find(Item.class, id);
    }
    
    /**
     * Busca entidades {@link Item} cujo nome contém a string especificada.
     *
     * @param nome Parte ou totalidade do nome a ser buscado.
     * @return Lista de entidades {@link Item} que correspondem ao critério de busca.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Item> buscarPorNome(String nome) {
        String jpql = "SELECT i FROM Item i WHERE i.nome LIKE :nome";
        TypedQuery<Item> consulta = em.createQuery(jpql, Item.class);
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
