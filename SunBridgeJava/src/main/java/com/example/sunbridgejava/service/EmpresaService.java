package com.example.sunbridgejava.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sunbridgejava.model.Empresa;
import com.example.sunbridgejava.repository.EmpresaRepository;

/**
 * Serviço responsável por gerenciar as operações relacionadas à entidade {@code Empresa}.
 */
@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository r;
 
    /**
     * Busca uma empresa pelo ID.
     *
     * @param ID Identificador da empresa.
     * @return Optional contendo a empresa, se encontrada.
     */
    public Optional<Empresa> findById(int ID) {
        System.out.println("Pesquisa Empresa pelo id: " + ID);
        return r.findById(ID).map(empresas -> {
            return empresas;
        });
    }

    /**
     * Retorna todas as empresas registradas.
     *
     * @return Lista de todas as empresas.
     */
    public List<Empresa> findAll() {
        System.out.println("Pesquisa Cliente todos");
        return r.findAll();
    }

    /**
     * Deleta uma empresa pelo ID.
     *
     * @param id Identificador da empresa.
     */
    public void deleteById(int id) {
        System.out.println("Delete Empresa pelo id: " + id);
        r.deleteById(id);
    }

    /**
     * Atualiza as informações de uma empresa existente.
     *
     * @param companyID         Identificador da empresa.
     * @param empresaAtualizada Dados atualizados da empresa.
     * @return Optional contendo a empresa atualizada, se encontrada.
     */
    public Optional<Empresa> update(int companyID, Empresa empresaAtualizada) {
        System.out.println("update Empresa pelo id: " + companyID);
        return r.findById(companyID).map(empresaExistente -> {
            // Atualiza apenas os campos fornecidos na empresaAtualizada
            if (empresaAtualizada.getNome() != null) empresaExistente.setNome(empresaAtualizada.getNome());
            if (empresaAtualizada.getEmail() != null) empresaExistente.setEmail(empresaAtualizada.getEmail());
            if (empresaAtualizada.getTelefone() != null) empresaExistente.setTelefone(empresaAtualizada.getTelefone());
            if (empresaAtualizada.getWebsiteURL() != null) empresaExistente.setWebsiteURL(empresaAtualizada.getWebsiteURL());
            if (empresaAtualizada.getCidade() != null) empresaExistente.setCidade(empresaAtualizada.getCidade());
            if (empresaAtualizada.getProvincia() != null) empresaExistente.setProvincia(empresaAtualizada.getProvincia());
            if (empresaAtualizada.getData_fundacao() != null) empresaExistente.setData_fundacao(empresaAtualizada.getData_fundacao());
            if (empresaAtualizada.getCedula_juridica() != null) empresaExistente.setCedula_juridica(empresaAtualizada.getCedula_juridica());
            if (empresaAtualizada.getSetor() != null) empresaExistente.setSetor(empresaAtualizada.getSetor());
            if (empresaAtualizada.getNumero_licenca() != null) empresaExistente.setNumero_licenca(empresaAtualizada.getNumero_licenca());
            if (empresaAtualizada.getRua() != null) empresaExistente.setRua(empresaAtualizada.getRua());
            if (empresaAtualizada.getBairro() != null) empresaExistente.setBairro(empresaAtualizada.getBairro());
            if (empresaAtualizada.getCanton() != null) empresaExistente.setCanton(empresaAtualizada.getCanton());
            if (empresaAtualizada.getDistrito() != null) empresaExistente.setDistrito(empresaAtualizada.getDistrito());
            if (empresaAtualizada.getCodigo_postal() != 0) empresaExistente.setCodigo_postal(empresaAtualizada.getCodigo_postal());
            if (empresaAtualizada.getComplemento() != null) empresaExistente.setComplemento(empresaAtualizada.getComplemento());

            // Salvar as alterações no banco de dados
            return r.save(empresaExistente);
        });
    }

    /**
     * Cria uma nova empresa.
     *
     * @param empresas Dados da empresa a ser criada.
     * @return Empresa criada.
     */
    public Empresa create(Empresa empresas) {
        System.out.println("Create Empresa");
        validaNulo(empresas);
        // Salvar Empresa no banco
        return r.save(empresas);
    }

    /**
     * Valida os campos obrigatórios de uma empresa.
     *
     * @param empresa Empresa a ser validada.
     * @throws IllegalArgumentException Caso algum campo obrigatório esteja ausente ou inválido.
     */
    private void validaNulo(Empresa empresa) {
        if (empresa.getNome() == null || empresa.getNome().isEmpty()) {
            throw new IllegalArgumentException("O campo 'nome' não pode ser nulo ou vazio.");
        }
        if (empresa.getWebsiteURL() == null || empresa.getWebsiteURL().isEmpty()) {
            throw new IllegalArgumentException("O campo 'websiteURL' não pode ser nulo ou vazio.");
        }
        if (empresa.getEmail() == null || empresa.getEmail().isEmpty()) {
            throw new IllegalArgumentException("O campo 'email' não pode ser nulo ou vazio.");
        }
        if (empresa.getTelefone() == null || empresa.getTelefone().isEmpty()) {
            throw new IllegalArgumentException("O campo 'telefone' não pode ser nulo ou vazio.");
        }
        if (empresa.getCidade() == null || empresa.getCidade().isEmpty()) {
            throw new IllegalArgumentException("O campo 'cidade' não pode ser nulo ou vazio.");
        }
        if (empresa.getProvincia() == null || empresa.getProvincia().isEmpty()) {
            throw new IllegalArgumentException("O campo 'provincia' não pode ser nulo ou vazio.");
        }
        if (empresa.getCedula_juridica() == null || empresa.getCedula_juridica().isEmpty()) {
            throw new IllegalArgumentException("O campo 'cedula_juridica' não pode ser nulo ou vazio.");
        }
        if (empresa.getNumero_licenca() == null || empresa.getNumero_licenca().isEmpty()) {
            throw new IllegalArgumentException("O campo 'numero_licenca' não pode ser nulo ou vazio.");
        }
        if (empresa.getRua() == null || empresa.getRua().isEmpty()) {
            throw new IllegalArgumentException("O campo 'rua' não pode ser nulo ou vazio.");
        }
        if (empresa.getBairro() == null || empresa.getBairro().isEmpty()) {
            throw new IllegalArgumentException("O campo 'bairro' não pode ser nulo ou vazio.");
        }
        if (empresa.getCanton() == null || empresa.getCanton().isEmpty()) {
            throw new IllegalArgumentException("O campo 'canton' não pode ser nulo ou vazio.");
        }
        if (empresa.getDistrito() == null || empresa.getDistrito().isEmpty()) {
            throw new IllegalArgumentException("O campo 'distrito' não pode ser nulo ou vazio.");
        }
        if (empresa.getCodigo_postal() <= 0) {
            throw new IllegalArgumentException("O campo 'codigo_postal' deve ser maior que zero.");
        }
    }
}
