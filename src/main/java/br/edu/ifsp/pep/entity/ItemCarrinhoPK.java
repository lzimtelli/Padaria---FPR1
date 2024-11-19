/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import java.io.Serializable;

/**
 *
 * @author User
 */
public class ItemCarrinhoPK implements Serializable{
    
      @Basic(optional = false)
    @Column(name = "id_item", nullable = false)
    private int idItemVenda;
    @Basic(optional = false)
    @Column(name = "id_venda", nullable = false)
    private int carrinho;

    public int getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(int idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public int getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(int carrinho) {
        this.carrinho = carrinho;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.idItemVenda;
        hash = 73 * hash + this.carrinho;
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
        final ItemCarrinhoPK other = (ItemCarrinhoPK) obj;
        if (this.idItemVenda != other.idItemVenda) {
            return false;
        }
        return this.carrinho == other.carrinho;
    }
    
    

    
    
}
