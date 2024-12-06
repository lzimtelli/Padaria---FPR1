/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.CarrinhoDAO;
import br.edu.ifsp.pep.entity.Carrinho;
import br.edu.ifsp.pep.entity.ItemCarrinho;
import br.edu.ifsp.pep.entity.Produto;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.faces.annotation.View;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author User
 */
@Named
@View //verificar notacao correta
public class CarrinhoController implements Serializable {

    @Inject
    private CarrinhoDAO carrinhoDAO;

    //ver se ta ok
    private Carrinho carrinho;

    private Produto produtoSelecionado;

    private Integer quantidade;

    private List<Produto> itens;

    public void adicionar() {

       
        produtoSelecionado = null;
        Mensagem.sucesso("Produto adicionado.");

    }
    
    public void limparCarrinho(){
        
        itens = null;
        
    }

    public CarrinhoDAO getCarrinhoDAO() {
        return carrinhoDAO;
    }

    public void setCarrinhoDAO(CarrinhoDAO carrinhoDAO) {
        this.carrinhoDAO = carrinhoDAO;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public List<Produto> getItens() {
        return itens;
    }

    public void setItens(List<Produto> itens) {
        this.itens = itens;
    }

 
}
