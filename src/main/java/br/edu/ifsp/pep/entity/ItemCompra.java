/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

/**
 *
 * @author User
 */
@Table(name = "item_compra")
@IdClass(ItemCompraPK.class)
public class ItemCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idItemCompra;
    
    @Id
    private Compra compra;
}
