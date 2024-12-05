/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.ProdutoDAO;
import br.edu.ifsp.pep.entity.Produto;
import br.edu.ifsp.pep.util.Mensagem;
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
public class ProdutoController implements Serializable {
    
      @Inject
    private ProdutoDAO  produtoDAO;

    private Produto produto = new Produto();
    private Produto produtoSelecionado = null;
    private List<Produto> produtos;
    
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
        System.out.println("teste");
        System.out.println(produtos.size());
    }

    public String adicionar() {

        produtoDAO.inserir(produto);

        produtos = null;

        //Criar categoria
        this.produto = new Produto();

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
       if(produtos == null){
           produtos = produtoDAO.buscarTodos();
       }
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
    
}
