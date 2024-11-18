/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

/**
 *
 * @author User
 */
public class ItemCarrinho {
    
    @Id
    private int idItemCarrinho;
    
    private Carrinho Carrinho;
    
   
    private Produto produto;
    
    @Column(name = "valor_venda",nullable = false)
    private Double valorVenda;
   
    @Column(nullable = false)
    private int quantidade;
    
   
}
