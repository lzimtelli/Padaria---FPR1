/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author User
 */
@Entity
@Table(name = "venda")
@NamedQueries({
    @NamedQuery(name = "Venda.buscarTodas", query = "FROM Venda v"),
  //  @NamedQuery(name = "Venda.buscarPorData",  query = "FROM Venda v WHERE v.data BETWEEN :datainicio AND :datafim"),
})
public class Venda implements Serializable{
    
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
