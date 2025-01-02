package com.example.sunbridgejava.dao;

import java.util.List;

import com.example.sunbridgejava.model.Empresa;
import com.example.sunbridgejava.repository.EmpresaRepository;
import com.example.sunbridgejava.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 * DAO (Data Access Object) para operações relacionadas à entidade {@link Empresa}.
 * 
 * <p>
 * Esta classe fornece métodos para realizar operações CRUD (Create, Read, Update, Delete) na entidade {@code Empresa}.
 * No entanto, ela está {@code @deprecated} e não deve mais ser utilizada. Recomenda-se utilizar a interface 
 * {@link EmpresaRepository} do Spring Data JPA para acesso a dados.
 * </p>
 * 
 * @deprecated A partir da versão 2.0, {@link DaoEmpresa} está obsoleta e será removida em versões futuras.
 *             Utilize {@link EmpresaRepository} em seu lugar.
 * @since 1.0
 */
@Deprecated
public class DaoEmpresa {
    
    /**
     * Gerenciador de entidades para operações de persistência.
     */
    private EntityManager em;
    
    /**
     * Construtor padrão que inicializa o {@link EntityManager}.
     */
    public DaoEmpresa() {
        em = JPAUtil.getEntityManager();
    }
    
    // Métodos privados
    
    /**
     * Inicia uma transação.
     *
     * @return A instância atual de {@link DaoEmpresa} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoEmpresa abreTrans() {
        em.getTransaction().begin();
        return this;
    }
    
    /**
     * Finaliza uma transação.
     *
     * @return A instância atual de {@link DaoEmpresa} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoEmpresa fechaTrans() {
        em.getTransaction().commit();
        return this;
    }
    
    /**
     * Persiste uma entidade {@link Empresa} no banco de dados.
     *
     * @param e A entidade {@link Empresa} a ser persistida.
     * @return A instância atual de {@link DaoEmpresa} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoEmpresa incluir(Empresa e) {
        em.persist(e);
        return this;
    }
    
    /**
     * Remove uma entidade {@link Empresa} do banco de dados.
     *
     * @param e A entidade {@link Empresa} a ser removida.
     * @return A instância atual de {@link DaoEmpresa} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoEmpresa remover(Empresa e) {
        em.remove(e);
        return this;
    }
    
    /**
     * Atualiza uma entidade {@link Empresa} no banco de dados.
     *
     * @param e A entidade {@link Empresa} a ser atualizada.
     * @return A instância atual de {@link DaoEmpresa} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoEmpresa atualizar(Empresa e) {
        em.merge(e);
        return this;
    }
    
    // Métodos públicos
    
    /**
     * Salva uma entidade {@link Empresa} no banco de dados.
     * 
     * <p>
     * Se o {@code empresaID} for menor ou igual a zero, a entidade será persistida como uma nova entrada.
     * Caso contrário, a entidade existente será atualizada.
     * </p>
     *
     * @param e A entidade {@link Empresa} a ser salva.
     * @return A instância atual de {@link DaoEmpresa} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoEmpresa salvar(Empresa e) {
        return this.abreTrans().incluir(e).fechaTrans();
    }
    
    
    /**
     * Exclui uma entidade {@link Empresa} do banco de dados.
     *
     * @param e A entidade {@link Empresa} a ser excluída.
     * @return A instância atual de {@link DaoEmpresa} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoEmpresa excluir(Empresa e) {
        return this.abreTrans().remover(e).fechaTrans();
    }
    
    /**
     * Obtém todos os registros de {@link Empresa} do banco de dados.
     *
     * @return Lista de todas as entidades {@link Empresa}.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Empresa> obterTodos() {
        String jpql = "SELECT e FROM Empresa e";
        return em.createQuery(jpql, Empresa.class).getResultList();
    }
    
    /**
     * Busca uma entidade {@link Empresa} pelo seu identificador.
     *
     * @param id O identificador da entidade {@link Empresa} a ser buscada.
     * @return A entidade {@link Empresa} encontrada, ou {@code null} se não existir.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public Empresa buscarPorId(Integer id) {
        return em.find(Empresa.class, id);
    }
    
    /**
     * Busca entidades {@link Empresa} cujo nome contém a string especificada.
     *
     * @param nome Parte ou totalidade do nome a ser buscado.
     * @return Lista de entidades {@link Empresa} que correspondem ao critério de busca.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Empresa> buscarPorNome(String nome) {
        String jpql = "SELECT e FROM Empresa e WHERE e.nome LIKE :nome";
        TypedQuery<Empresa> consulta = em.createQuery(jpql, Empresa.class);
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
