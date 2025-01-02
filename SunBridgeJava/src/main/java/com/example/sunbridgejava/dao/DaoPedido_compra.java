package com.example.sunbridgejava.dao;

import java.util.List;

import com.example.sunbridgejava.model.Pedido_compra;
import com.example.sunbridgejava.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 * DAO (Data Access Object) para operações relacionadas à entidade {@link Pedido_compra}.
 * 
 * <p>
 * Esta classe fornece métodos para realizar operações CRUD (Create, Read, Update, Delete) na entidade {@code Pedido_compra}.
 * No entanto, ela está {@code @deprecated} e não deve mais ser utilizada. Recomenda-se utilizar a interface 
 * {@link com.example.sunbridgejava.repository.pedidoCompraRepository} do Spring Data JPA para acesso a dados.
 * </p>
 * 
 * @deprecated A partir da versão 2.0, {@link DaoPedido_compra} está obsoleta e será removida em versões futuras.
 *             Utilize {@link com.example.sunbridgejava.repository.pedidoCompraRepository} em seu lugar.
 * @since 1.0
 */
@Deprecated
public class DaoPedido_compra {
    
    /**
     * Gerenciador de entidades para operações de persistência.
     */
    private EntityManager em;
    
    /**
     * Construtor padrão que inicializa o {@link EntityManager}.
     */
    public DaoPedido_compra() {
        em = JPAUtil.getEntityManager();
    }
    
    // Métodos privados
    
    /**
     * Inicia uma transação.
     *
     * @return A instância atual de {@link DaoPedido_compra} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoPedido_compra abreTrans() {
        em.getTransaction().begin();
        return this;
    }
    
    /**
     * Finaliza uma transação.
     *
     * @return A instância atual de {@link DaoPedido_compra} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoPedido_compra fechaTrans() {
        em.getTransaction().commit();
        return this;
    }
    
    /**
     * Persiste uma entidade {@link Pedido_compra} no banco de dados.
     *
     * @param pc A entidade {@link Pedido_compra} a ser persistida.
     * @return A instância atual de {@link DaoPedido_compra} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoPedido_compra incluir(Pedido_compra pc) {
        em.persist(pc);
        return this;
    }
    
    /**
     * Remove uma entidade {@link Pedido_compra} do banco de dados.
     *
     * @param pc A entidade {@link Pedido_compra} a ser removida.
     * @return A instância atual de {@link DaoPedido_compra} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    private DaoPedido_compra remover(Pedido_compra pc) {
        em.remove(pc);
        return this;
    }
    
    // Métodos públicos
    
    /**
     * Salva uma entidade {@link Pedido_compra} no banco de dados.
     * 
     * <p>
     * Este método persiste a entidade {@code Pedido_compra} como uma nova entrada no banco de dados.
     * Se o {@code pedidoCompraID} for menor ou igual a zero, a entidade será persistida como uma nova entrada.
     * Caso contrário, a entidade existente será atualizada.
     * </p>
     *
     * @param pc A entidade {@link Pedido_compra} a ser salva.
     * @return A instância atual de {@link DaoPedido_compra} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoPedido_compra salvar(Pedido_compra pc) {
        // Se aplicável, implemente a lógica condicional para inclusão ou atualização
        // Exemplo:
        // if (pc.getPedidoCompraID() <= 0) {
        //     return this.abreTrans().incluir(pc).fechaTrans();
        // } else {
        //     return this.abreTrans().atualizar(pc).fechaTrans();
        // }
        return this.abreTrans().incluir(pc).fechaTrans();
    }
    
    /**
     * Exclui uma entidade {@link Pedido_compra} do banco de dados.
     *
     * @param pc A entidade {@link Pedido_compra} a ser excluída.
     * @return A instância atual de {@link DaoPedido_compra} para encadeamento de métodos.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public DaoPedido_compra excluir(Pedido_compra pc) {
        return this.abreTrans().remover(pc).fechaTrans();
    }
    
    /**
     * Obtém todos os registros de {@link Pedido_compra} do banco de dados.
     *
     * @return Lista de todas as entidades {@link Pedido_compra}.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Pedido_compra> obterTodos() {
        String jpql = "SELECT pc FROM Pedido_compra pc";
        return em.createQuery(jpql, Pedido_compra.class).getResultList();
    }
    
    /**
     * Busca uma entidade {@link Pedido_compra} pelo seu identificador.
     *
     * @param id O identificador da entidade {@link Pedido_compra} a ser buscada.
     * @return A entidade {@link Pedido_compra} encontrada, ou {@code null} se não existir.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public Pedido_compra buscarPorId(Integer id) {
        return em.find(Pedido_compra.class, id);
    }
    
    /**
     * Busca entidades {@link Pedido_compra} associadas a um usuário cujo nome contém a string especificada.
     *
     * @param nome Parte ou totalidade do nome do usuário a ser buscado.
     * @return Lista de entidades {@link Pedido_compra} que correspondem ao critério de busca.
     * @deprecated Este método está obsoleto e não deve ser utilizado. Utilize métodos da interface de repositório do Spring Data JPA.
     */
    @Deprecated
    public List<Pedido_compra> buscarPorUsuario(String nome) {
        // Correção: Assumindo que existe uma relação entre Pedido_compra e Usuario, e que Pedido_compra possui um atributo 'usuario' do tipo Usuario
        String jpql = "SELECT pc FROM Pedido_compra pc WHERE pc.usuario.nome LIKE :nome";
        TypedQuery<Pedido_compra> consulta = em.createQuery(jpql, Pedido_compra.class);
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
