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
    
    private int idItemVenda;
    private Long idVenda;

    public int getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(int idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public ItemVendaPK() {
    }

    public ItemVendaPK(int idItemVenda, Long idVenda) {
        this.idItemVenda = idItemVenda;
        this.idVenda = idVenda;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idItemVenda;
        hash = 47 * hash + Objects.hashCode(this.idVenda);
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
        if (this.idItemVenda != other.idItemVenda) {
            return false;
        }
        return Objects.equals(this.idVenda, other.idVenda);
    }
    
    
}
