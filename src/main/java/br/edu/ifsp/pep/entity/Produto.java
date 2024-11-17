/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author User
 */
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;
    
    @Column(nullable = false,length = 50)
    private String descricao;
    
    @Column(name = "qtd_estoque",nullable = false)
    private int qtdEstoque;  //talvez mudar para double 
    
    @Column(name = "qtd_minima",nullable = true)
    private int qtdMinima; //idem
    
    @Column(name = "valor_compra",nullable = false)
    private Double valorCompra;
    
    @Column(name = "valor_venda",nullable = false)
    private Double valorVenda;
    
    
}
