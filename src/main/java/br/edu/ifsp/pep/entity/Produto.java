/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author User
 */
@Entity
@Table(name = "produto")
@NamedQueries({
    @NamedQuery(name = "Produto.buscaTodos", query = "FROM Produto p"),
      @NamedQuery(name = "Produto.buscaPorNome",  query = "SELECT p FROM Produto p WHERE p.descricao = :descricao"),      
})
public class Produto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria",referencedColumnName = "id_categoria",nullable = false)
    private Categoria categoria; 
    
    @Column(nullable = false,length = 50)
    private String descricao;
    
    @Column(name = "qtd_estoque",nullable = false)
    private int qtdEstoque;  //talvez mudar para double 
    
    @Column(name = "qtd_minima",nullable = true)
    private int qtdMinima; //idem
    
    @Column(name = "valor_compra",nullable = false)
    private Double valorCompra;
    
    @Column(name = "valor_venda",nullable = false)
    private Double valorVenda;
    

    public Produto() {
    }

    public Produto(Long idProduto, String descricao, int qtdEstoque, int qtdMinima, Double valorCompra, Double valorVenda, Categoria categoria) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.qtdEstoque = qtdEstoque;
        this.qtdMinima = qtdMinima;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.categoria = categoria;
    }
    
    
   

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public int getQtdMinima() {
        return qtdMinima;
    }

    public void setQtdMinima(int qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idProduto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        return Objects.equals(this.idProduto, other.idProduto);
    }

    @Override
    public String toString() {
        return "Produto{" + "idProduto=" + idProduto + ", descricao=" + descricao + ", qtdEstoque=" + qtdEstoque + ", qtdMinima=" + qtdMinima + ", valorCompra=" + valorCompra + ", valorVenda=" + valorVenda + ", categoria=" + categoria + '}';
    }
    
    
    
}
