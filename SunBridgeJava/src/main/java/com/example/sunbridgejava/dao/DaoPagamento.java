package com.example.sunbridgejava.dao;

import java.util.List;

import com.example.sunbridgejava.model.Pagamento;
import com.example.sunbridgejava.repository.PagamentoRepository;
import com.example.sunbridgejava.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 * DAO (Data Access Object) para operações relacionadas à entidade {@link Pagamento}.
 * 
 * <p>
 * Esta classe fornece métodos para realizar operações CRUD (Create, Read, Update, Delete) na entidade {@code Pagamento}.
 * No entanto, ela está {@code @deprecated} e não deve mais ser utilizada. Recomenda-se utilizar a interface 
 * {@link PagamentoRepository} do Spring Data JPA para acesso a dados.
 * </p>
 * 
 * @deprecated A partir da versão 2.0, {@link DaoPagamento} está obsoleta e será removida em versões futuras.
 *             Utilize {@link PagamentoRepository} em seu lugar.
 * @since 1.0
 */
@Deprecated
public class DaoPagamento {
    
    /**
     * Gerenciador de entidades para operações de persistência.
     */
    private EntityManager em;
    
    /**
     * Construtor padrão que inicializa o {@link EntityManager}.
     */
    public DaoPagamento() {
        em = JPAUtil.getEntityManager();
    }
    
    // Métodos privados
    
    /**
     * Inicia uma transação.
     *
     * @return A instância atual de {@link DaoPagamento} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoPagamento abreTrans() {
        em.getTransaction().begin();
        return this;
    }
    
    /**
     * Finaliza uma transação.
     *
     * @return A instância atual de {@link DaoPagamento} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoPagamento fechaTrans() {
        em.getTransaction().commit();
        return this;
    }
    
    /**
     * Persiste uma entidade {@link Pagamento} no banco de dados.
     *
     * @param p A entidade {@link Pagamento} a ser persistida.
     * @return A instância atual de {@link DaoPagamento} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoPagamento incluir(Pagamento p) {
        em.persist(p);
        return this;
    }
    
    /**
     * Remove uma entidade {@link Pagamento} do banco de dados.
     *
     * @param p A entidade {@link Pagamento} a ser removida.
     * @return A instância atual de {@link DaoPagamento} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoPagamento remover(Pagamento p) {
        em.remove(p);
        return this;
    }
    
    // Métodos públicos
    
    /**
     * Salva uma entidade {@link Pagamento} no banco de dados.
     * 
     * <p>
     * Este método persiste a entidade {@code Pagamento} como uma nova entrada no banco de dados.
     * Se o {@code pagamentoID} for menor ou igual a zero, a entidade será persistida como uma nova entrada.
     * Caso contrário, a entidade existente será atualizada.
     * </p>
     *
     * @param p A entidade {@link Pagamento} a ser salva.
     * @return A instância atual de {@link DaoPagamento} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoPagamento salvar(Pagamento p) {
        // Se aplicável, implemente a lógica condicional para inclusão ou atualização
        // Exemplo:
        // if (p.getPagamentoID() <= 0) {
        //     return this.abreTrans().incluir(p).fechaTrans();
        // } else {
        //     return this.abreTrans().atualizar(p).fechaTrans();
        // }
        return this.abreTrans().incluir(p).fechaTrans();
    }
    
    /**
     * Exclui uma entidade {@link Pagamento} do banco de dados.
     *
     * @param p A entidade {@link Pagamento} a ser excluída.
     * @return A instância atual de {@link DaoPagamento} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoPagamento excluir(Pagamento p) {
        return this.abreTrans().remover(p).fechaTrans();
    }
    
    /**
     * Obtém todos os registros de {@link Pagamento} do banco de dados.
     *
     * @return Lista de todas as entidades {@link Pagamento}.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Pagamento> obterTodos() {
        String jpql = "SELECT p FROM Pagamento p";
        return em.createQuery(jpql, Pagamento.class).getResultList();
    }
    
    /**
     * Busca uma entidade {@link Pagamento} pelo seu identificador.
     *
     * @param id O identificador da entidade {@link Pagamento} a ser buscada.
     * @return A entidade {@link Pagamento} encontrada, ou {@code null} se não existir.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public Pagamento buscarPorId(Integer id) {
        return em.find(Pagamento.class, id);
    }
    
    /**
     * Busca entidades {@link Pagamento} associadas a um cliente cujo nome contém a string especificada.
     *
     * @param nome Parte ou totalidade do nome do cliente a ser buscado.
     * @return Lista de entidades {@link Pagamento} que correspondem ao critério de busca.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Pagamento> buscarPorCliente(String nome) {
        String jpql = "SELECT p FROM Pagamento p WHERE p.cliente.nome LIKE :nome";
        TypedQuery<Pagamento> consulta = em.createQuery(jpql, Pagamento.class);
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
