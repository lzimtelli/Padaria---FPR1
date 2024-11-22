/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author User
 */
public class ItemCarrinhoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_produto", nullable = false)
    private Long produto;
    @Basic(optional = false)
    @Column(name = "id_carrinho", nullable = false)
    private Long carrinho;

    public Long getProduto() {
        return produto;
    }

    public void setProduto(Long produto) {
        this.produto = produto;
    }

    public Long getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Long carrinho) {
        this.carrinho = carrinho;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.produto);
        hash = 17 * hash + Objects.hashCode(this.carrinho);
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
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return Objects.equals(this.carrinho, other.carrinho);
    }

    

 

}
