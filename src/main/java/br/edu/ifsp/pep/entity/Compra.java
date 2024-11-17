/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author User
 */
@Table(name = "compra")
public class Compra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Long idCompra;
    
    @Column(nullable = false)
    private Fornecedor fornecedor;
    
    
    private List<ItemCompra> itemCompras;
    
    @Column(name = "forma_pagamento",nullable = false,length = 20)
    private String formaPagamento;
   
    @Column(nullable = true)
    private Double desconto;

    public Compra() {
    }

    public Compra(Long idCompra, Fornecedor fornecedor, List<ItemCompra> itemCompras, String formaPagamento, Double desconto) {
        this.idCompra = idCompra;
        this.fornecedor = fornecedor;
        this.itemCompras = itemCompras;
        this.formaPagamento = formaPagamento;
        this.desconto = desconto;
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<ItemCompra> getItemCompras() {
        return itemCompras;
    }

    public void setItemCompras(List<ItemCompra> itemCompras) {
        this.itemCompras = itemCompras;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.idCompra);
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
        final Compra other = (Compra) obj;
        return Objects.equals(this.idCompra, other.idCompra);
    }
    
    
    
    
}
