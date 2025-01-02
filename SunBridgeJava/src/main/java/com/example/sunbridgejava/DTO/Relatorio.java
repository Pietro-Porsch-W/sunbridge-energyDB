package com.example.sunbridgejava.DTO;

import com.example.sunbridgejava.model.Usuario;
import com.example.sunbridgejava.repository.ItemRepository;
import com.example.sunbridgejava.repository.Pedido_vendaRepository;
import com.example.sunbridgejava.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class Relatorio {

    @Autowired
    private Pedido_vendaRepository pedidoVendaRepo;

    @Autowired
    private ItemRepository itemRepo;

    @Autowired
    private ClienteRepository clienteRepo;

    /**
     * Verifica se o usuário tem permissão para acessar relatórios.
     *
     * @param usuario Usuário que solicita o relatório.
     */
    private void verificarPermissao(Usuario usuario) {
        if (usuario.getTipo() != 1 || !usuario.getDepartamento().equalsIgnoreCase("administrador")) {
            throw new IllegalArgumentException("Sem permissão");
        }
    }

    /**
     * Relatório de vendas por período e por funcionário.
     *
     * @param usuario   Usuário que solicita o relatório.
     * @param inicio    Data de início do período.
     * @param fim       Data de fim do período.
     * @return Lista de pedidos de venda no período solicitado.
     */
    public List<?> relatorioVendas(Usuario usuario, Date inicio, Date fim) {
        verificarPermissao(usuario);
        return pedidoVendaRepo.buscarPorPeriodo(inicio, fim);
    }

    /**
     * Relatório de estoque (itens disponíveis e itens abaixo do limite).
     *
     * @param usuario Usuário que solicita o relatório.
     * @return Lista de itens e sua disponibilidade.
     */
    public List<?> relatorioEstoque(Usuario usuario) {
        verificarPermissao(usuario);
        return itemRepo.findAll(); // Adapte para retornar itens disponíveis e abaixo do limite.
    }

    /**
     * Relatório de clientes (histórico de compras e status de dívidas).
     *
     * @param usuario Usuário que solicita o relatório.
     * @return Lista de clientes com histórico de compras e status de dívidas.
     */
    public List<?> relatorioClientes(Usuario usuario) {
        verificarPermissao(usuario);
        return clienteRepo.findAll(); // Adapte para incluir histórico de compras e status de dívidas.
    }
}
