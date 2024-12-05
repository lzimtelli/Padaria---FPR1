/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author User
 *
 */
@Embeddable
public class ItemVendaPK implements Serializable{
    
    private Long venda;
    private Long produtoVenda;

    public Long getVenda() {
        return venda;
    }

    public void setVenda(Long venda) {
        this.venda = venda;
    }

    public Long getProdutoVenda() {
        return produtoVenda;
    }

    public void setProdutoVenda(Long produtoVenda) {
        this.produtoVenda = produtoVenda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.venda);
        hash = 41 * hash + Objects.hashCode(this.produtoVenda);
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
        final ItemVendaPK other = (ItemVendaPK) obj;
        if (!Objects.equals(this.venda, other.venda)) {
            return false;
        }
        return Objects.equals(this.produtoVenda, other.produtoVenda);
    }

   
    
}
