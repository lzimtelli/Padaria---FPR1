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
    
    private int idItemCompra;
    private Long idVenda;

    public int getIdItemCompra() {
        return idItemCompra;
    }

    public void setIdItemCompra(int idItemCompra) {
        this.idItemCompra = idItemCompra;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.idItemCompra;
        hash = 41 * hash + Objects.hashCode(this.idVenda);
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
        if (this.idItemCompra != other.idItemCompra) {
            return false;
        }
        return Objects.equals(this.idVenda, other.idVenda);
    }

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }
    
    
}
