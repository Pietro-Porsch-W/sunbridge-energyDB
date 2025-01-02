package com.example.sunbridgejava.dao;

import java.util.List;

import com.example.sunbridgejava.model.Pedido_fornecedor;
import com.example.sunbridgejava.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 * DAO (Data Access Object) para operações relacionadas à entidade {@link Pedido_fornecedor}.
 * 
 * <p>
 * Esta classe fornece métodos para realizar operações CRUD (Create, Read, Update, Delete) na entidade {@code Pedido_fornecedor}.
 * No entanto, ela está {@code @deprecated} e não deve mais ser utilizada. Recomenda-se utilizar a interface 
 * {@link com.example.sunbridgejava.repository.pedidoFornecedorRepository} do Spring Data JPA para acesso a dados.
 * </p>
 * 
 * @deprecated A partir da versão 2.0, {@link DaoPedido_fornecedor} está obsoleta e será removida em versões futuras.
 *             Utilize {@link com.example.sunbridgejava.repository.pedidoFornecedorRepository} em seu lugar.
 * @since 1.0
 */
@Deprecated
public class DaoPedido_fornecedor {
    
    /**
     * Gerenciador de entidades para operações de persistência.
     */
    private EntityManager em;
    
    /**
     * Construtor padrão que inicializa o {@link EntityManager}.
     */
    public DaoPedido_fornecedor() {
        em = JPAUtil.getEntityManager();
    }
    
    // Métodos privados 
    
    /**
     * Inicia uma transação.
     *
     * @return A instância atual de {@link DaoPedido_fornecedor} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoPedido_fornecedor abreTrans() {
        em.getTransaction().begin();
        return this;
    }
    
    /**
     * Finaliza uma transação.
     *
     * @return A instância atual de {@link DaoPedido_fornecedor} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoPedido_fornecedor fechaTrans() {
        em.getTransaction().commit();
        return this;
    }
    
    /**
     * Persiste uma entidade {@link Pedido_fornecedor} no banco de dados.
     *
     * @param p A entidade {@link Pedido_fornecedor} a ser persistida.
     * @return A instância atual de {@link DaoPedido_fornecedor} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoPedido_fornecedor incluir(Pedido_fornecedor p) {
        em.persist(p);
        return this;
    }
    
    /**
     * Remove uma entidade {@link Pedido_fornecedor} do banco de dados.
     *
     * @param p A entidade {@link Pedido_fornecedor} a ser removida.
     * @return A instância atual de {@link DaoPedido_fornecedor} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoPedido_fornecedor remover(Pedido_fornecedor p) {
        em.remove(p);
        return this;
    }
    
    // Métodos públicos
    
    /**
     * Salva uma entidade {@link Pedido_fornecedor} no banco de dados.
     * 
     * <p>
     * Este método persiste a entidade {@code Pedido_fornecedor} como uma nova entrada no banco de dados.
     * Se o {@code pedidoFornecedorID} for menor ou igual a zero, a entidade será persistida como uma nova entrada.
     * Caso contrário, a entidade existente será atualizada.
     * </p>
     *
     * @param pc A entidade {@link Pedido_fornecedor} a ser salva.
     * @return A instância atual de {@link DaoPedido_fornecedor} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoPedido_fornecedor salvar(Pedido_fornecedor pc) {
        // Se aplicável, implemente a lógica condicional para inclusão ou atualização
        // Exemplo:
        // if (pc.getPedidoFornecedorID() <= 0) {
        //     return this.abreTrans().incluir(pc).fechaTrans();
        // } else {
        //     return this.abreTrans().atualizar(pc).fechaTrans();
        // }
        return this.abreTrans().incluir(pc).fechaTrans();
    }
    
    /**
     * Exclui uma entidade {@link Pedido_fornecedor} do banco de dados.
     *
     * @param pc A entidade {@link Pedido_fornecedor} a ser excluída.
     * @return A instância atual de {@link DaoPedido_fornecedor} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoPedido_fornecedor excluir(Pedido_fornecedor pc) {
        return this.abreTrans().remover(pc).fechaTrans();
    }
    
    /**
     * Obtém todos os registros de {@link Pedido_fornecedor} do banco de dados.
     *
     * @return Lista de todas as entidades {@link Pedido_fornecedor}.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Pedido_fornecedor> obterTodos() {
        String jpql = "SELECT p FROM Pedido_fornecedor p";
        return em.createQuery(jpql, Pedido_fornecedor.class).getResultList();
    }
    
    /**
     * Busca uma entidade {@link Pedido_fornecedor} pelo seu identificador.
     *
     * @param id O identificador da entidade {@link Pedido_fornecedor} a ser buscada.
     * @return A entidade {@link Pedido_fornecedor} encontrada, ou {@code null} se não existir.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public Pedido_fornecedor buscarPorId(Integer id) {
        return em.find(Pedido_fornecedor.class, id);
    }
    
    /**
     * Busca entidades {@link Pedido_fornecedor} associadas a um pedido de compra cujo identificador contém a string especificada.
     *
     * @param ped_compra Parte ou totalidade do identificador do pedido de compra a ser buscado.
     * @return Lista de entidades {@link Pedido_fornecedor} que correspondem ao critério de busca.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Pedido_fornecedor> buscarPorPed_compra(String ped_compra) {
        // Correção: Assumindo que o campo correto é 'ped_compra' na entidade Pedido_fornecedor
        String jpql = "SELECT p FROM Pedido_fornecedor p WHERE p.ped_compra LIKE :ped_compra";
        TypedQuery<Pedido_fornecedor> consulta = em.createQuery(jpql, Pedido_fornecedor.class);
        consulta.setParameter("ped_compra", "%" + ped_compra + "%");
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
