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
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author User
 */
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private int idEndereco;

    //necessario colocar o cliente aqui
    //verificar como será feito cliente / usuario
    
    @Column(nullable = false, length = 50)
    private String cidade;

    @Column(nullable = false, length = 50)
    private String logradouro;

    @Column(nullable = false, length = 50)
    private String bairro;

    @Column(nullable = false, length = 50)
    private String referencia;

    @Column(nullable = false)
    private int numero;
    
    

}
