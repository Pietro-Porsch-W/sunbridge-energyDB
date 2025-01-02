package com.example.sunbridgejava.dao;

import java.util.List;

import com.example.sunbridgejava.model.Pedido_venda;
import com.example.sunbridgejava.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 * DAO (Data Access Object) para operações relacionadas à entidade {@link Pedido_venda}.
 * 
 * <p>
 * Esta classe fornece métodos para realizar operações CRUD (Create, Read, Update, Delete) na entidade {@code Pedido_venda}.
 * No entanto, ela está {@code @deprecated} e não deve mais ser utilizada. Recomenda-se utilizar a interface 
 * {@link com.example.sunbridgejava.repository.pedidoVendaRepository} do Spring Data JPA para acesso a dados.
 * </p>
 * 
 * @deprecated A partir da versão 2.0, {@link DaoPedido_venda} está obsoleta e será removida em versões futuras.
 *             Utilize {@link com.example.sunbridgejava.repository.pedidoVendaRepository} em seu lugar.
 * @since 1.0
 */
@Deprecated
public class DaoPedido_venda {
    
    /**
     * Gerenciador de entidades para operações de persistência.
     */
    private EntityManager em;
    
    /**
     * Construtor padrão que inicializa o {@link EntityManager}.
     */
    public DaoPedido_venda() {
        em = JPAUtil.getEntityManager();
    }
    
    // Métodos privados
    
    /**
     * Inicia uma transação.
     *
     * @return A instância atual de {@link DaoPedido_venda} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoPedido_venda abreTrans() {
        em.getTransaction().begin();
        return this;
    }
    
    /**
     * Finaliza uma transação.
     *
     * @return A instância atual de {@link DaoPedido_venda} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoPedido_venda fechaTrans() {
        em.getTransaction().commit();
        return this;
    }
    
    /**
     * Persiste uma entidade {@link Pedido_venda} no banco de dados.
     *
     * @param p A entidade {@link Pedido_venda} a ser persistida.
     * @return A instância atual de {@link DaoPedido_venda} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoPedido_venda incluir(Pedido_venda p) {
        em.persist(p);
        return this;
    }
    
    /**
     * Remove uma entidade {@link Pedido_venda} do banco de dados.
     *
     * @param p A entidade {@link Pedido_venda} a ser removida.
     * @return A instância atual de {@link DaoPedido_venda} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoPedido_venda remover(Pedido_venda p) {
        em.remove(p);
        return this;
    }
    
    // Métodos públicos
    
    /**
     * Salva uma entidade {@link Pedido_venda} no banco de dados.
     * 
     * <p>
     * Este método persiste a entidade {@code Pedido_venda} como uma nova entrada no banco de dados.
     * Se o {@code pedidoVendaID} for menor ou igual a zero, a entidade será persistida como uma nova entrada.
     * Caso contrário, a entidade existente será atualizada.
     * </p>
     *
     * @param p A entidade {@link Pedido_venda} a ser salva.
     * @return A instância atual de {@link DaoPedido_venda} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoPedido_venda salvar(Pedido_venda p) {
        // Se aplicável, implemente a lógica condicional para inclusão ou atualização
        // Exemplo:
        // if (p.getPedidoVendaID() <= 0) {
        //     return this.abreTrans().incluir(p).fechaTrans();
        // } else {
        //     return this.abreTrans().atualizar(p).fechaTrans();
        // }
        return this.abreTrans().incluir(p).fechaTrans();
    }
    
    /**
     * Exclui uma entidade {@link Pedido_venda} do banco de dados.
     *
     * @param p A entidade {@link Pedido_venda} a ser excluída.
     * @return A instância atual de {@link DaoPedido_venda} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoPedido_venda excluir(Pedido_venda p) {
        return this.abreTrans().remover(p).fechaTrans();
    }
    
    /**
     * Obtém todos os registros de {@link Pedido_venda} do banco de dados.
     *
     * @return Lista de todas as entidades {@link Pedido_venda}.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Pedido_venda> obterTodos() {
        String jpql = "SELECT p FROM Pedido_venda p";
        return em.createQuery(jpql, Pedido_venda.class).getResultList();
    }
    
    /**
     * Busca uma entidade {@link Pedido_venda} pelo seu identificador.
     *
     * @param id O identificador da entidade {@link Pedido_venda} a ser buscada.
     * @return A entidade {@link Pedido_venda} encontrada, ou {@code null} se não existir.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public Pedido_venda buscarPorId(Integer id) {
        return em.find(Pedido_venda.class, id);
    }
    
    /**
     * Busca entidades {@link Pedido_venda} associadas a um cliente cujo nome contém a string especificada.
     *
     * @param nome Parte ou totalidade do nome do cliente a ser buscado.
     * @return Lista de entidades {@link Pedido_venda} que correspondem ao critério de busca.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Pedido_venda> buscarPorCliente(String nome) {
        // Correção: Assumindo que existe uma relação entre Pedido_venda e Cliente, e que Pedido_venda possui um atributo 'cliente' do tipo Cliente
        String jpql = "SELECT p FROM Pedido_venda p WHERE p.cliente.nome LIKE :nome";
        TypedQuery<Pedido_venda> consulta = em.createQuery(jpql, Pedido_venda.class);
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
