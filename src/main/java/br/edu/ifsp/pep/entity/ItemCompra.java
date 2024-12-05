/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author User
 */
@Entity
@Table(name = "item_compra")
@IdClass(ItemCompraPK.class)
public class ItemCompra implements Serializable {

    @Id   
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto", nullable = false)
    @ManyToOne(optional = false)
    private Produto produto;
    
    @Id
    @JoinColumn(name = "id_compra", referencedColumnName = "id_compra", nullable = false)
    @ManyToOne(optional = false)
    private Compra compra;

    @Column(name = "data_compra", nullable = false)
    private LocalDate dataCompra;

    @Column(name = "desconto", nullable = true)
    private Double desconto;
    
    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

 
    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

}
