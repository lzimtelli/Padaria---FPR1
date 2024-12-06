/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.ProdutoDAO;
import br.edu.ifsp.pep.entity.Categoria;
import br.edu.ifsp.pep.entity.Produto;
import br.edu.ifsp.pep.entity.ProdutoStatus;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import org.primefaces.PrimeFaces;

/**
 *
 * @author User
 */
@Named
@ViewScoped
public class ProdutoController implements Serializable {

    @Inject
    private ProdutoDAO produtoDAO;

    private Produto produto = new Produto();
    private Produto produtoSelecionado = new Produto();
    private List<Produto> produtos;

    private Categoria selectedCategoria = null;

    public void remover() {
        if (produtoSelecionado != null) {
            System.out.println("Removendo produto selecionado.");
            produtoDAO.excluir(produtoSelecionado);
            produtos = null;

            Mensagem.sucesso("categoria exclucída.");
        } else {
            Mensagem.atencao("Selecione umca categoria.");
        }
    }

    public void prepararCadastro() {
        produtoSelecionado = new Produto();
        System.out.println("teste");
        // System.out.println(produtos.size());;
    }

    public String adicionar() {

        produtoDAO.inserir(produtoSelecionado);
        produtos = null;
        // Criar categoria
        this.produtoSelecionado = new Produto();

        Mensagem.sucesso("Produto cadastrado com sucesso");

        return null;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

    public List<Produto> getProdutos() {
        if (produtos == null) {
            produtos = produtoDAO.buscarTodos();
        }
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public ProdutoDAO getProdutoDAO() {
        return produtoDAO;
    }

    public void setProdutoDAO(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public Categoria getSelectedCategoria() {
        return selectedCategoria;
    }

    public void setSelectedCategoria(Categoria selectedCategoria) {
        this.selectedCategoria = selectedCategoria;
    }

    public void alterar() {
        produtoDAO.alterar(produtoSelecionado);
        produtos = null;
        this.produtoSelecionado = new Produto();

        // Criar categoria
        Mensagem.sucesso("produto alterado.");

    }

    public void save() {
        System.out.println("acima");
        System.out.println(selectedCategoria.getDescricao());
        produtoSelecionado.setCategoria(selectedCategoria);
        produtoSelecionado.setProdutoStatus(ProdutoStatus.Disponivel);
        System.out.println(produtoSelecionado);
        if (this.produtoSelecionado.getIdProduto() == null) {

            this.adicionar();
            // FacesContext.getCurrentInstance().addMessage(null, new
            // FacesMessage("Categoria adicionada"));
        } else {
            this.alterar();
            // FacesContext.getCurrentInstance().addMessage(null, new
            // FacesMessage("Categoria Atualizada"));
        }

        PrimeFaces.current().executeScript("PF('manageCategoriaDialog').hide()");
        PrimeFaces.current().ajax().update("form2:products", "grow");
    }

    public boolean hasSelectedProd() {
        System.out.println("oiaq");
        if (produtoSelecionado == null || produtoSelecionado.getIdProduto() == null) {
            return false;
        }
        return true;

    }

}
