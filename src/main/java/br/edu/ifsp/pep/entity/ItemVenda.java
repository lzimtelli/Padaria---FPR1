/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author User
 */
@Entity
@Table(name = "item_venda")
@IdClass(ItemVendaPK.class)
public class ItemVenda implements Serializable{

    
    @Id
    @JoinColumn(name = "id_venda",referencedColumnName = "id_venda",nullable = false)
    @ManyToOne(optional = false)
    private Venda venda;
    

    @Id
    @JoinColumn(name = "produto_venda",referencedColumnName = "id_produto",nullable = false)
    @ManyToOne(optional = false)
    private Produto produtoVenda;
    
    private int quantidade;
    
    @Column(name = "valor_unitario")
    private Double valorUnitario;

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }


    public Produto getProdutoVenda() {
        return produtoVenda;
    }

    public void setProdutoVenda(Produto produtoVenda) {
        this.produtoVenda = produtoVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
    
}
