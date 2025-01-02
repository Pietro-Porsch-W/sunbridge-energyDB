package com.example.sunbridgejava.dao;

import java.util.List;

import com.example.sunbridgejava.model.Item_venda;
import com.example.sunbridgejava.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 * DAO (Data Access Object) para operações relacionadas à entidade {@link Item_venda}.
 * 
 * <p>
 * Esta classe fornece métodos para realizar operações CRUD (Create, Read, Update, Delete) na entidade {@code Item_venda}.
 * No entanto, ela está {@code @deprecated} e não deve mais ser utilizada. Recomenda-se utilizar a interface 
 * {@link com.example.sunbridgejava.repository.itemVendaRepository} do Spring Data JPA para acesso a dados.
 * </p>
 * 
 * @deprecated A partir da versão 2.0, {@link DaoItem_venda} está obsoleta e será removida em versões futuras.
 *             Utilize {@link com.example.sunbridgejava.repository.itemVendaRepository} em seu lugar.
 * @since 1.0
 */
@Deprecated
public class DaoItem_venda {
    
    /**
     * Gerenciador de entidades para operações de persistência.
     */
    private EntityManager em;
    
    /**
     * Construtor padrão que inicializa o {@link EntityManager}.
     */
    public DaoItem_venda() {
        em = JPAUtil.getEntityManager();
    }
    
    // Métodos privados
    
    /**
     * Inicia uma transação.
     *
     * @return A instância atual de {@link DaoItem_venda} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoItem_venda abreTrans() {
        em.getTransaction().begin();
        return this;
    }
    
    /**
     * Finaliza uma transação.
     *
     * @return A instância atual de {@link DaoItem_venda} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoItem_venda fechaTrans() {
        em.getTransaction().commit();
        return this;
    }
    
    /**
     * Persiste uma entidade {@link Item_venda} no banco de dados.
     *
     * @param i A entidade {@link Item_venda} a ser persistida.
     * @return A instância atual de {@link DaoItem_venda} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoItem_venda incluir(Item_venda i) {
        em.persist(i);
        return this;
    }
    
    /**
     * Remove uma entidade {@link Item_venda} do banco de dados.
     *
     * @param i A entidade {@link Item_venda} a ser removida.
     * @return A instância atual de {@link DaoItem_venda} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoItem_venda remover(Item_venda i) {
        em.remove(i);
        return this;
    }
    
    // Métodos públicos
    
    /**
     * Salva uma entidade {@link Item_venda} no banco de dados.
     * 
     * <p>
     * Se o {@code itemVendaID} for menor ou igual a zero, a entidade será persistida como uma nova entrada.
     * Caso contrário, a entidade existente será atualizada.
     * </p>
     *
     * @param i A entidade {@link Item_venda} a ser salva.
     * @return A instância atual de {@link DaoItem_venda} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoItem_venda salvar(Item_venda i) {
        return this.abreTrans().incluir(i).fechaTrans();
    }
    
    /**
     * Exclui uma entidade {@link Item_venda} do banco de dados.
     *
     * @param i A entidade {@link Item_venda} a ser excluída.
     * @return A instância atual de {@link DaoItem_venda} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoItem_venda excluir(Item_venda i) {
        return this.abreTrans().remover(i).fechaTrans();
    }
    
    /**
     * Obtém todos os registros de {@link Item_venda} do banco de dados.
     *
     * @return Lista de todas as entidades {@link Item_venda}.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Item_venda> obterTodos() {
        String jpql = "SELECT i FROM Item_venda i";
        return em.createQuery(jpql, Item_venda.class).getResultList();
    }
    
    /**
     * Busca uma entidade {@link Item_venda} pelo seu identificador.
     *
     * @param id O identificador da entidade {@link Item_venda} a ser buscada.
     * @return A entidade {@link Item_venda} encontrada, ou {@code null} se não existir.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public Item_venda buscarPorId(Integer id) {
        return em.find(Item_venda.class, id);
    }
    
    /**
     * Busca entidades {@link Item_venda} cujo pedido de venda contém a string especificada.
     *
     * @param ped_venda Parte ou totalidade do pedido de venda a ser buscado.
     * @return Lista de entidades {@link Item_venda} que correspondem ao critério de busca.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Item_venda> buscarPorNome(String ped_venda) {
        String jpql = "SELECT i FROM Item_venda i WHERE i.ped_venda LIKE :ped_venda";
        TypedQuery<Item_venda> consulta = em.createQuery(jpql, Item_venda.class);
        consulta.setParameter("ped_venda", "%" + ped_venda + "%");
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
