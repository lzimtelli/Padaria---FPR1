/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author User
 */
@Table(name = "item_venda")
@IdClass(ItemVendaPK.class)
public class ItemVenda {
    
    @Id
    private int idItemVenda;
    
    @Id
    @ManyToMany  //deve ta certo
    private Venda idVenda;
    
    @OneToMany
   @Column(name = "produto_venda")
    private Produto produtoVenda;
    
    private int quantidade;
    
    @Column(name = "valor_unitario")
    private Double valorUnitario;
}
