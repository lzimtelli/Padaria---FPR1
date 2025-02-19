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
import java.util.Objects;

/**
 *
 * @author User
 */
@Entity
@Table(name = "fornecedor")
@NamedQueries({
    @NamedQuery(name = "Fornecedor.buscaTodos", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.buscaPorNome", query = "SELECT f FROM Fornecedor f WHERE f.nomeFantasia LiKE :nome")
     
})
public class Fornecedor implements Serializable{
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fornecedor")
    private Long idFornecedor;
    
    @Column(nullable = false,length = 50)
    private String nomeFantasia;
    
    @Column(nullable = true,length = 50)
    private String razaoSocial;
    
    @Column(nullable = false,length = 50)
    private String representante;
    
    @Column(nullable = true,length = 40)
    private String cnpj;
    
    @Column(nullable = false,length = 40)
    private String email;
    
    @Column(nullable = false,length = 18)
    private String telefone;

    public Fornecedor() {
    }

    public Fornecedor(Long idFornecedor, String nomeFantasia, String razaoSocial, String representante, String cnpj, String email, String telefone) {
        this.idFornecedor = idFornecedor;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.representante = representante;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Long idForncedor) {
        this.idFornecedor = idForncedor;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.idFornecedor);
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
        final Fornecedor other = (Fornecedor) obj;
        return Objects.equals(this.idFornecedor, other.idFornecedor);
    }
    
    
    
}
