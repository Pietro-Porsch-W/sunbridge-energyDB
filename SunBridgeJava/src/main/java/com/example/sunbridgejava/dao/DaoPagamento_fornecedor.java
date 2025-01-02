package com.example.sunbridgejava.dao;

import java.util.List;

import com.example.sunbridgejava.model.Pagamento_fornecedor;
import com.example.sunbridgejava.util.JPAUtil;

import jakarta.persistence.EntityManager;

/**
 * DAO (Data Access Object) para operações relacionadas à entidade {@link Pagamento_fornecedor}.
 * 
 * <p>
 * Esta classe fornece métodos para realizar operações CRUD (Create, Read, Update, Delete) na entidade {@code Pagamento_fornecedor}.
 * No entanto, ela está {@code @deprecated} e não deve mais ser utilizada. Recomenda-se utilizar a interface 
 * {@link com.example.sunbridgejava.repository.pagamentoFornecedorRepository} do Spring Data JPA para acesso a dados.
 * </p>
 * 
 * @deprecated A partir da versão 2.0, {@link DaoPagamento_fornecedor} está obsoleta e será removida em versões futuras.
 *             Utilize {@link com.example.sunbridgejava.repository.pagamentoFornecedorRepository} em seu lugar.
 * @since 1.0
 */
@Deprecated
public class DaoPagamento_fornecedor {
    
    /**
     * Gerenciador de entidades para operações de persistência.
     */
    private EntityManager em;
    
    /**
     * Construtor padrão que inicializa o {@link EntityManager}.
     */
    public DaoPagamento_fornecedor() {
        em = JPAUtil.getEntityManager();
    }
    
    // Métodos privados
    
    /**
     * Inicia uma transação.
     *
     * @return A instância atual de {@link DaoPagamento_fornecedor} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoPagamento_fornecedor abreTrans() {
        em.getTransaction().begin();
        return this;
    }
    
    /**
     * Finaliza uma transação.
     *
     * @return A instância atual de {@link DaoPagamento_fornecedor} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoPagamento_fornecedor fechaTrans() {
        em.getTransaction().commit();
        return this;
    }
    
    /**
     * Persiste uma entidade {@link Pagamento_fornecedor} no banco de dados.
     *
     * @param p A entidade {@link Pagamento_fornecedor} a ser persistida.
     * @return A instância atual de {@link DaoPagamento_fornecedor} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoPagamento_fornecedor incluir(Pagamento_fornecedor p) {
        em.persist(p);
        return this;
    }
    
    /**
     * Remove uma entidade {@link Pagamento_fornecedor} do banco de dados.
     *
     * @param p A entidade {@link Pagamento_fornecedor} a ser removida.
     * @return A instância atual de {@link DaoPagamento_fornecedor} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoPagamento_fornecedor remover(Pagamento_fornecedor p) {
        em.remove(p);
        return this;
    }
    
    // Métodos públicos
    
    /**
     * Salva uma entidade {@link Pagamento_fornecedor} no banco de dados.
     * 
     * <p>
     * Este método persiste a entidade {@code Pagamento_fornecedor} como uma nova entrada no banco de dados.
     * Se o {@code pagamentoFornecedorID} for menor ou igual a zero, a entidade será persistida como uma nova entrada.
     * Caso contrário, a entidade existente será atualizada.
     * </p>
     *
     * @param p A entidade {@link Pagamento_fornecedor} a ser salva.
     * @return A instância atual de {@link DaoPagamento_fornecedor} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoPagamento_fornecedor salvar(Pagamento_fornecedor p) {
        // Se aplicável, implemente a lógica condicional para inclusão ou atualização
        // Exemplo:
        // if (p.getPagamentoFornecedorID() <= 0) {
        //     return this.abreTrans().incluir(p).fechaTrans();
        // } else {
        //     return this.abreTrans().atualizar(p).fechaTrans();
        // }
        return this.abreTrans().incluir(p).fechaTrans();
    }
    
    /**
     * Exclui uma entidade {@link Pagamento_fornecedor} do banco de dados.
     *
     * @param p A entidade {@link Pagamento_fornecedor} a ser excluída.
     * @return A instância atual de {@link DaoPagamento_fornecedor} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoPagamento_fornecedor excluir(Pagamento_fornecedor p) {
        return this.abreTrans().remover(p).fechaTrans();
    }
    
    /**
     * Obtém todos os registros de {@link Pagamento_fornecedor} do banco de dados.
     *
     * @return Lista de todas as entidades {@link Pagamento_fornecedor}.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Pagamento_fornecedor> obterTodos() {
        String jpql = "SELECT p FROM Pagamento_fornecedor p";
        return em.createQuery(jpql, Pagamento_fornecedor.class).getResultList();
    }
    
    /**
     * Busca uma entidade {@link Pagamento_fornecedor} pelo seu identificador.
     *
     * @param id O identificador da entidade {@link Pagamento_fornecedor} a ser buscada.
     * @return A entidade {@link Pagamento_fornecedor} encontrada, ou {@code null} se não existir.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public Pagamento_fornecedor buscarPorId(Integer id) {
        return em.find(Pagamento_fornecedor.class, id);
    }
    
    /*
    /**
     * Busca entidades {@link Pagamento_fornecedor} cujo nome contém a string especificada.
     *
     * @param nome Parte ou totalidade do nome a ser buscado.
     * @return Lista de entidades {@link Pagamento_fornecedor} que correspondem ao critério de busca.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     *
    @Deprecated
    public List<Pagamento_fornecedor> buscarPorNome(String nome) {
        String jpql = "SELECT p FROM Pagamento_fornecedor p WHERE p.nome LIKE :nome";
        TypedQuery<Pagamento_fornecedor> consulta = em.createQuery(jpql, Pagamento_fornecedor.class);
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }
    */
    
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
