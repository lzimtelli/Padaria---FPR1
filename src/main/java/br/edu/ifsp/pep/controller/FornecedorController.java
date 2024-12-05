/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.FornecedorDAO;
import br.edu.ifsp.pep.entity.Fornecedor;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.faces.annotation.View;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author User
 */
@Named
@ViewScoped
public class FornecedorController implements Serializable{
    
    
    @Inject
    private FornecedorDAO fornecedorDAO;

    private Fornecedor fornecedor = new Fornecedor();
    private Fornecedor fornecedorSelecionado;

    private List<Fornecedor> fornecedores;

    public void remover() {
        if (fornecedorSelecionado != null) {
            System.out.println("Removendo cFornecedor selecionada.");
            fornecedorDAO.excluir(fornecedorSelecionado);
            fornecedores = null;

            Mensagem.sucesso("Fornecedor excluído.");
        } else {
            Mensagem.atencao("Selecione um Fornecedor.");
        }
    }

    public void prepararCadastro() {
        System.out.println("teste");
        System.out.println(fornecedores.size());
    }

    public String adicionar() {

        fornecedorDAO.inserir(fornecedor);

        fornecedores = null;

        //Criar Fornecedor
        this.fornecedor = new Fornecedor();

        Mensagem.sucesso("Fornecedor cadastrado");

        return null;
    }

    public FornecedorDAO getFornecedorDAO() {
        return fornecedorDAO;
    }

    public void setFornecedorDAO(FornecedorDAO fornecedorDAO) {
        this.fornecedorDAO = fornecedorDAO;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Fornecedor getFornecedorSelecionado() {
        return fornecedorSelecionado;
    }

    public void setFornecedorSelecionado(Fornecedor fornecedorSelecionado) {
        this.fornecedorSelecionado = fornecedorSelecionado;
    }

    public List<Fornecedor> getFornecedores() {
         if (fornecedores == null) {
            System.out.println("Buscando os fornecedores no DB");
            fornecedores = fornecedorDAO.buscarTodos();
        }
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }
    
    
}
