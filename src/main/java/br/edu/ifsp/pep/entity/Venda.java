/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Venda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Long idVenda;
    
    //colocar cliente 
    
    @Column(name = "data_venda",nullable = false)
    private LocalDate dataVenda = LocalDate.now(); //verificar se é uma boa pratica
    
    @Column(nullable = true)
    private Double desconto;
}
