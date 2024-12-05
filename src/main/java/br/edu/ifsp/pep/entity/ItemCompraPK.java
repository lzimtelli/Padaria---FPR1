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
 */
@Embeddable
public class ItemCompraPK implements Serializable{
    
    private Long compra;
    private Long produto;

    public ItemCompraPK() {}

    public ItemCompraPK(Long compra, Long produto) {
        this.compra = compra;
        this.produto = produto;
    }
    
    public Long getCompra() {
        return compra;
    }

    public void setCompra(Long compra) {
        this.compra = compra;
    }

    public Long getProduto() {
        return produto;
    }

    public void setProduto(Long produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.compra);
        hash = 29 * hash + Objects.hashCode(this.produto);
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
        final ItemCompraPK other = (ItemCompraPK) obj;
        if (!Objects.equals(this.compra, other.compra)) {
            return false;
        }
        return Objects.equals(this.produto, other.produto);
    }

   

   

 
    
}
