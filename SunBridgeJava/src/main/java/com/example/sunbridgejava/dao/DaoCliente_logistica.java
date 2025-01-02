package com.example.sunbridgejava.dao;

import java.util.List;

import com.example.sunbridgejava.model.Cliente_logistica;
import com.example.sunbridgejava.repository.Cliente_logisticaRepository;
import com.example.sunbridgejava.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 * DAO (Data Access Object) para operações relacionadas à entidade {@link Cliente_logistica}.
 * 
 * <p>
 * Esta classe fornece métodos para realizar operações CRUD (Create, Read, Update, Delete) na entidade {@code Cliente_logistica}.
 * No entanto, ela está {@code @deprecated} e não deve mais ser utilizada. Recomenda-se utilizar a interface 
 * {@link Cliente_logisticaRepository} do Spring Data JPA para acesso a dados.
 * </p>
 * 
 * @deprecated A partir da versão 2.0, {@link DaoCliente_logistica} está obsoleta e será removida em versões futuras.
 *             Utilize {@link Cliente_logisticaRepository} em seu lugar.
 * @since 1.0
 */
@Deprecated
public class DaoCliente_logistica {
    
    /**
     * Gerenciador de entidades para operações de persistência.
     */
    private EntityManager em;
    
    /**
     * Construtor padrão que inicializa o {@link EntityManager}.
     */
    public DaoCliente_logistica() {
        em = JPAUtil.getEntityManager();
    }
    
    // Métodos privados
    
    /**
     * Inicia uma transação.
     *
     * @return A instância atual de {@link DaoCliente_logistica} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoCliente_logistica abreTrans() {
        em.getTransaction().begin();
        return this;
    }
    
    /**
     * Finaliza uma transação.
     *
     * @return A instância atual de {@link DaoCliente_logistica} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoCliente_logistica fechaTrans() {
        em.getTransaction().commit();
        return this;
    }
    
    /**
     * Persiste uma entidade {@link Cliente_logistica} no banco de dados.
     *
     * @param c A entidade {@link Cliente_logistica} a ser persistida.
     * @return A instância atual de {@link DaoCliente_logistica} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoCliente_logistica incluir(Cliente_logistica c) {
        em.persist(c);
        return this;
    }
    
    /**
     * Remove uma entidade {@link Cliente_logistica} do banco de dados.
     *
     * @param c A entidade {@link Cliente_logistica} a ser removida.
     * @return A instância atual de {@link DaoCliente_logistica} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoCliente_logistica remover(Cliente_logistica c) {
        em.remove(c);
        return this;
    }
    
    // Métodos públicos
    
    /**
     * Salva uma entidade {@link Cliente_logistica} no banco de dados.
     *
     * @param c A entidade {@link Cliente_logistica} a ser salva.
     * @return A instância atual de {@link DaoCliente_logistica} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoCliente_logistica salvar(Cliente_logistica c) {
        return this.abreTrans().incluir(c).fechaTrans();
    }
    
    /**
     * Exclui uma entidade {@link Cliente_logistica} do banco de dados.
     *
     * @param c A entidade {@link Cliente_logistica} a ser excluída.
     * @return A instância atual de {@link DaoCliente_logistica} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoCliente_logistica excluir(Cliente_logistica c) {
        return this.abreTrans().remover(c).fechaTrans();
    }
    
    /**
     * Obtém todos os registros de {@link Cliente_logistica} do banco de dados.
     *
     * @return Lista de todas as entidades {@link Cliente_logistica}.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Cliente_logistica> obterTodos() {
        String jpql = "SELECT c FROM Cliente_logistica c";
        return em.createQuery(jpql, Cliente_logistica.class).getResultList();
    }
    
    /**
     * Busca uma entidade {@link Cliente_logistica} pelo seu identificador.
     *
     * @param id O identificador da entidade {@link Cliente_logistica} a ser buscada.
     * @return A entidade {@link Cliente_logistica} encontrada, ou {@code null} se não existir.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public Cliente_logistica buscarPorId(Integer id) {
        return em.find(Cliente_logistica.class, id);
    }
    
    /**
     * Busca entidades {@link Cliente_logistica} cujo nome contém a string especificada.
     *
     * @param nome Parte ou totalidade do nome a ser buscado.
     * @return Lista de entidades {@link Cliente_logistica} que correspondem ao critério de busca.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Cliente_logistica> buscarPorNome(String nome) {
        String jpql = "SELECT c FROM Cliente_logistica c WHERE c.nome LIKE :nome";
        TypedQuery<Cliente_logistica> consulta = em.createQuery(jpql, Cliente_logistica.class);
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
