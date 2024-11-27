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
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author User
 */
@Entity
@Table(name = "item_carrinho")
@IdClass(ItemCarrinhoPK.class)
public class ItemCarrinho implements Serializable{
    
    //@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private int idItemCarrinho;
    
    @Id
    @JoinColumn(name = "id_carrinho",referencedColumnName = "id_carrinho",nullable = false)
    @ManyToOne
    private Carrinho carrinho;
    
    @Id
    @JoinColumn(name = "id_produto",referencedColumnName = "id_produto",nullable = false)
    @ManyToOne   
    private Produto produto;
    
    @Column(name = "valor_venda",nullable = false)
    private Double valorVenda;
   
    @Column(nullable = false)
    private int quantidade;

    public int getIdItemCarrinho() {
        return idItemCarrinho;
    }

    public void setIdItemCarrinho(int idItemCarrinho) {
        this.idItemCarrinho = idItemCarrinho;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.carrinho);
        hash = 53 * hash + Objects.hashCode(this.produto);
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
        final ItemCarrinho other = (ItemCarrinho) obj;
        if (!Objects.equals(this.carrinho, other.carrinho)) {
            return false;
        }
        return Objects.equals(this.produto, other.produto);
    }

 
    
    
   
}
