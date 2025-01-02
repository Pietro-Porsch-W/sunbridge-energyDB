package com.example.sunbridgejava.dao;

import java.util.List;

import com.example.sunbridgejava.model.Fornecedor;
import com.example.sunbridgejava.repository.FornecedorRepository;
import com.example.sunbridgejava.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 * DAO (Data Access Object) para operações relacionadas à entidade {@link Fornecedor}.
 * 
 * <p>
 * Esta classe fornece métodos para realizar operações CRUD (Create, Read, Update, Delete) na entidade {@code Fornecedor}.
 * No entanto, ela está {@code @deprecated} e não deve mais ser utilizada. Recomenda-se utilizar a interface 
 * {@link FornecedorRepository} do Spring Data JPA para acesso a dados.
 * </p>
 * 
 * @deprecated A partir da versão 2.0, {@link DaoFornecedor} está obsoleta e será removida em versões futuras.
 *             Utilize {@link FornecedorRepository} em seu lugar.
 * @since 1.0
 */
@Deprecated
public class DaoFornecedor {
    
    /**
     * Gerenciador de entidades para operações de persistência.
     */
    private EntityManager em;
    
    /**
     * Construtor padrão que inicializa o {@link EntityManager}.
     */
    public DaoFornecedor() {
        em = JPAUtil.getEntityManager();
    }
    
    // Métodos privados
    
    /**
     * Inicia uma transação.
     *
     * @return A instância atual de {@link DaoFornecedor} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoFornecedor abreTrans() {
        em.getTransaction().begin();
        return this;
    }
    
    /**
     * Finaliza uma transação.
     *
     * @return A instância atual de {@link DaoFornecedor} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoFornecedor fechaTrans() {
        em.getTransaction().commit();
        return this;
    }
    
    /**
     * Persiste uma entidade {@link Fornecedor} no banco de dados.
     *
     * @param f A entidade {@link Fornecedor} a ser persistida.
     * @return A instância atual de {@link DaoFornecedor} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoFornecedor incluir(Fornecedor f) {
        em.persist(f);
        return this;
    }
    
    /**
     * Remove uma entidade {@link Fornecedor} do banco de dados.
     *
     * @param f A entidade {@link Fornecedor} a ser removida.
     * @return A instância atual de {@link DaoFornecedor} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoFornecedor remover(Fornecedor f) {
        em.remove(f);
        return this;
    }
    
    // Métodos públicos
    
    /**
     * Salva uma entidade {@link Fornecedor} no banco de dados.
     * 
     * <p>
     * Se o {@code fornecedorID} for menor ou igual a zero, a entidade será persistida como uma nova entrada.
     * Caso contrário, a entidade existente será atualizada.
     * </p>
     *
     * @param f A entidade {@link Fornecedor} a ser salva.
     * @return A instância atual de {@link DaoFornecedor} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoFornecedor salvar(Fornecedor f) {
        return this.abreTrans().incluir(f).fechaTrans();
    }
    
    /**
     * Exclui uma entidade {@link Fornecedor} do banco de dados.
     *
     * @param f A entidade {@link Fornecedor} a ser excluída.
     * @return A instância atual de {@link DaoFornecedor} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoFornecedor excluir(Fornecedor f) {
        return this.abreTrans().remover(f).fechaTrans();
    }
    
    /**
     * Obtém todos os registros de {@link Fornecedor} do banco de dados.
     *
     * @return Lista de todas as entidades {@link Fornecedor}.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Fornecedor> obterTodos() {
        String jpql = "SELECT f FROM Fornecedor f";
        return em.createQuery(jpql, Fornecedor.class).getResultList();
    }
    
    /**
     * Busca uma entidade {@link Fornecedor} pelo seu identificador.
     *
     * @param id O identificador da entidade {@link Fornecedor} a ser buscada.
     * @return A entidade {@link Fornecedor} encontrada, ou {@code null} se não existir.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public Fornecedor buscarPorId(Integer id) {
        return em.find(Fornecedor.class, id);
    }
    
    /**
     * Busca entidades {@link Fornecedor} cujo nome contém a string especificada.
     *
     * @param nome Parte ou totalidade do nome a ser buscado.
     * @return Lista de entidades {@link Fornecedor} que correspondem ao critério de busca.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Fornecedor> buscarPorNome(String nome) {
        String jpql = "SELECT f FROM Fornecedor f WHERE f.nome LIKE :nome";
        TypedQuery<Fornecedor> consulta = em.createQuery(jpql, Fornecedor.class);
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
